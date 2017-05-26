package com.bluedreamstar.core.service;

import com.bluedreamstar.core.po.UserBasisMessagePo;

/**
 * 用户操作Service接口类
 * @author zbxeva00
 *
 */
public interface IUserOperationService {

	/**
	 * 根据用户名获取用户基础信息
	 * @param userName 用户登录名
	 * @return
	 */
	public UserBasisMessagePo selectUserBasisMessageByUserName(String userName);
	
}
