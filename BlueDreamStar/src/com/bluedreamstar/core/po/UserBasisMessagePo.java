package com.bluedreamstar.core.po;

import org.apache.ibatis.type.Alias;

/**
 * 用户基础信息表Po
 * @author zbxeva00
 *
 */
@Alias("UserBasisMessagePo")
public class UserBasisMessagePo {
	
	//用户主键ID
	private String id;
	
	//用户登录名
	private String userName;
	
	//用户登录密码
	private String password;
	
	//用户昵称
	private String nickName;

	//用户有效标志
	private String yxbz;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getYxbz() {
		return yxbz;
	}

	public void setYxbz(String yxbz) {
		this.yxbz = yxbz;
	}

	public String toString() {
		return "UserBasisMessagePo [id=" + id + ", userName=" + userName + ", password=" + password + ", nickName="
				+ nickName + ", yxbz=" + yxbz + "]";
	}

}
