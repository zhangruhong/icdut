package com.vtars.cdut.bean;

import java.io.Serializable;

public class User implements Serializable {

	private static final long serialVersionUID = -2243864196444382794L;
	private String username;
	private String password;
	private String wxid;// 绑定的微信
	private boolean activestate; // 是否激活
	private UserDetail userdetail;// 连接到详细信息

	public User() {
		super();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getWxid() {
		return wxid;
	}

	public void setWxid(String wxid) {
		this.wxid = wxid;
	}

	public boolean isActivestate() {
		return activestate;
	}

	public void setActivestate(boolean activestate) {
		this.activestate = activestate;
	}

	public UserDetail getUserdetail() {
		return userdetail;
	}

	public void setUserdetail(UserDetail userdetail) {
		this.userdetail = userdetail;
	}
}
