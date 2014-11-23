package com.vtars.cdut.aao.Model;

import java.io.Serializable;

/**
 * 学生详细信息描述类
 * 
 * @author jack
 *
 */
public class UserDetail implements Serializable {

	private static final long serialVersionUID = 1096975736980788957L;
	private String userDetailid;
	private String idCardNo;// 身份证号 用于确定归属地等信息
	private String nick; // 昵称
	private String realName;// 姓名
	private String tel; // 联系电话
	private String address; // 家庭地址
	private String email; // email邮件
	private boolean gender; // 性别
	private String selfIntro;// 备注或简介
	private User user;

	public UserDetail() {
		super();
	}

	public String getUserDetailid() {
		return userDetailid;
	}

	public void setUserDetailid(String userDetailid) {
		this.userDetailid = userDetailid;
	}

	public String getIdCardNo() {
		return idCardNo;
	}

	public void setIdCardNo(String idCardNo) {
		this.idCardNo = idCardNo;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public String getSelfIntro() {
		return selfIntro;
	}

	public void setSelfIntro(String selfIntro) {
		this.selfIntro = selfIntro;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + (gender ? 1231 : 1237);
		result = prime * result
				+ ((idCardNo == null) ? 0 : idCardNo.hashCode());
		result = prime * result + ((nick == null) ? 0 : nick.hashCode());
		result = prime * result
				+ ((realName == null) ? 0 : realName.hashCode());
		result = prime * result
				+ ((selfIntro == null) ? 0 : selfIntro.hashCode());
		result = prime * result + ((tel == null) ? 0 : tel.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		result = prime * result
				+ ((userDetailid == null) ? 0 : userDetailid.hashCode());
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
		UserDetail other = (UserDetail) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (gender != other.gender)
			return false;
		if (idCardNo == null) {
			if (other.idCardNo != null)
				return false;
		} else if (!idCardNo.equals(other.idCardNo))
			return false;
		if (nick == null) {
			if (other.nick != null)
				return false;
		} else if (!nick.equals(other.nick))
			return false;
		if (realName == null) {
			if (other.realName != null)
				return false;
		} else if (!realName.equals(other.realName))
			return false;
		if (selfIntro == null) {
			if (other.selfIntro != null)
				return false;
		} else if (!selfIntro.equals(other.selfIntro))
			return false;
		if (tel == null) {
			if (other.tel != null)
				return false;
		} else if (!tel.equals(other.tel))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		if (userDetailid == null) {
			if (other.userDetailid != null)
				return false;
		} else if (!userDetailid.equals(other.userDetailid))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UserDetail [userDetailid=" + userDetailid + ", idCardNo="
				+ idCardNo + ", nick=" + nick + ", realName=" + realName
				+ ", tel=" + tel + ", address=" + address + ", email=" + email
				+ ", gender=" + gender + ", selfIntro=" + selfIntro + "]";
	}

}
