package com.bluedreamstar.core.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.bluedreamstar.core.po.UserBasisMessagePo;

public class SessionInterceptor implements HandlerInterceptor {

	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		
	}

	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		
	}

	public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object arg2) throws Exception {
		//验证用户session是否存在
		//如果是登陆请求则不进行session验证，直接放行
		String servletPath = req.getServletPath();
		if (servletPath.endsWith("/userOperationController_userLogin.do") || servletPath.endsWith("/userOperationController_jumpToIndex.do")) {
			return true;
		}
		//用户session如果存在则放行，不存在则跳转到登陆页面
		UserBasisMessagePo userBasisMessage = (UserBasisMessagePo)req.getSession().getAttribute("usersession");
		if (userBasisMessage != null) {
			return true;
		} else {
			resp.sendRedirect(req.getContextPath());
			return false;
		}
	}

}
