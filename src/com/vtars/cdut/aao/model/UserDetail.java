package com.vtars.cdut.aao.model;

import java.io.Serializable;

/**
 * ѧ����ϸ��Ϣ������
 * 
 * @author jack
 *
 */
public class UserDetail implements Serializable {

	private static final long serialVersionUID = 1096975736980788957L;
	private String userDetailid;
	private String idCardNo;// ���֤�� ����ȷ�������ص���Ϣ
	private String nick; // �ǳ�
	private String realName;// ����
	private String tel; // ��ϵ�绰
	private String address; // ��ͥ��ַ
	private String email; // email�ʼ�
	private boolean gender; // �Ա�
	private String selfIntro;// ��ע����
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

	
	
}
