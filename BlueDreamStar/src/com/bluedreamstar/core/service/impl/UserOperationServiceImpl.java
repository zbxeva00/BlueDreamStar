package com.bluedreamstar.core.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bluedreamstar.core.dao.IUserOperationDao;
import com.bluedreamstar.core.po.UserBasisMessagePo;
import com.bluedreamstar.core.service.IUserOperationService;

/**
 * 用户操作Service实现类
 * @author zbxeva00
 *
 */
@Transactional(propagation=Propagation.REQUIRED)
@Service("userOperationService")
public class UserOperationServiceImpl implements IUserOperationService {
	
	@Resource(name="userOperationDao")
	private IUserOperationDao userOperationDao;

	/**
	 * 根据用户名获取用户基础信息
	 */
	public UserBasisMessagePo selectUserBasisMessageByUserName(String userName) {
		UserBasisMessagePo resultObj = userOperationDao.selectUserBasisMessageByUserName(userName);
		return resultObj;
	}
	
}
