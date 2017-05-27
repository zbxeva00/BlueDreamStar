package com.bluedreamstar.core.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bluedreamstar.core.po.UserBasisMessagePo;
import com.bluedreamstar.core.service.IUserOperationService;

/**
 * 用户操作控制器
 * @author zbxeva00
 *
 */
@Controller
public class UserOperationController {
	
	@Resource(name="userOperationService")
	private IUserOperationService userOperationService;
	
	/**
	 * 跳转首页
	 * @param request
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/userOperationController_jumpToIndex.do",method=RequestMethod.GET)
	public String jumpToIndex(HttpServletRequest request, Map<String, Object>map) throws Exception{
		return "/index";
	}
	
	/**
	 * 登陆验证
	 * @param request
	 * @param map
	 * @param username 用户登录名
	 * @param password 用户登陆密码
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/userOperationController_userLogin.do",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> userLogin(HttpServletRequest request, Map<String, Object>map, String username, String password) {
		Map<String, Object> ajaxMap = new HashMap<String, Object>();
		String loginFlag = "false";
		String loginMessage = "";
		if (username != null && !"".equals(username) && password != null && !"".equals(password)) {
			UserBasisMessagePo userBasisMessageObj = userOperationService.selectUserBasisMessageByUserName(username);
			if (userBasisMessageObj != null) {
				if (password.equals(userBasisMessageObj.getPassword())) {
					if ("Y".equals(userBasisMessageObj.getYxbz())) {
						loginFlag = "true";
						loginMessage = "登陆成功！";
						userBasisMessageObj.setPassword("");
						request.getSession().setAttribute("usersession", userBasisMessageObj);
					} else {
						loginMessage = "该用户已被封禁，请联系管理员进行处理！";
					}
				} else {
					loginMessage = "用户登录密码错误！";
				}
			} else {
				loginMessage = "该用户登录名不存在！";
			}
		} else {
			loginMessage = "用户登录名和登录密码不能为空！";
		}
		ajaxMap.put("loginFlag", loginFlag);
		ajaxMap.put("loginMessage", loginMessage);
		return ajaxMap;
	}
	
	/**
	 * 验证session是否存在
	 * @param request
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/userOperationController_sessionValidation.do",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> sessionValidation(HttpServletRequest request, Map<String, Object>map) {
		Map<String, Object> ajaxMap = new HashMap<String, Object>();
		String sessionValidationFlag = "false";
		String userNickName = "";
		if (request.getSession().getAttribute("usersession") != null) {
			sessionValidationFlag = "true";
			userNickName = ((UserBasisMessagePo)request.getSession().getAttribute("usersession")).getNickName();
		}
		ajaxMap.put("sessionValidationFlag", sessionValidationFlag);
		ajaxMap.put("userNickName", userNickName);
		return ajaxMap;
	}
	
	/**
	 * 登出操作
	 * @param request
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/userOperationController_userLogout.do",method=RequestMethod.GET)
	public String userLogout(HttpServletRequest request, Map<String, Object>map) throws Exception{
		request.getSession().setAttribute("usersession", null);
		return "/index";
	}
	
}
