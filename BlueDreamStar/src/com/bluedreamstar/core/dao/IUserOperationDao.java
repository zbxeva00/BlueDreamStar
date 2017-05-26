package com.bluedreamstar.core.dao;

import org.springframework.stereotype.Repository;

import com.bluedreamstar.core.po.UserBasisMessagePo;

/**
 * 用户操作Dao接口类
 * @author zbxeva00
 *
 */
@Repository("userOperationDao")
public interface IUserOperationDao {
	
	/**
	 * 根据用户名获取用户基础信息
	 * @param userName 用户登录名
	 * @return
	 */
	public UserBasisMessagePo selectUserBasisMessageByUserName(String userName);
	
}
