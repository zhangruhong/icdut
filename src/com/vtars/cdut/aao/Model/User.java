package com.vtars.cdut.aao.Model;

import java.io.Serializable;
import java.util.Set;

public class User implements Serializable {
	private static final long serialVersionUID = -2243864196444382794L;
	private String username;
	private String password;
	private String wxid;// 绑定的微信
	private boolean activestate; // 是否激活
	private UserDetail userdetail;// 连接到详细信息
	private Set<GradeBean> grades;// 1-N关联关系，使用实体来保存关联关系

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
	

	public Set<GradeBean> getGrades() {
		return grades;
	}

	public void setGrades(Set<GradeBean> grades) {
		this.grades = grades;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (activestate ? 1231 : 1237);
		result = prime * result + ((grades == null) ? 0 : grades.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime * result
				+ ((userdetail == null) ? 0 : userdetail.hashCode());
		result = prime * result
				+ ((username == null) ? 0 : username.hashCode());
		result = prime * result + ((wxid == null) ? 0 : wxid.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (activestate != other.activestate)
			return false;
		if (grades == null) {
			if (other.grades != null)
				return false;
		} else if (!grades.equals(other.grades))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (userdetail == null) {
			if (other.userdetail != null)
				return false;
		} else if (!userdetail.equals(other.userdetail))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		if (wxid == null) {
			if (other.wxid != null)
				return false;
		} else if (!wxid.equals(other.wxid))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password
				+ ", wxid=" + wxid + ", activestate=" + activestate
				+ ", userdetail=" + userdetail + "]";
	}

}
