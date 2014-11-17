package com.vtars.cdut.aao.Action;

import com.opensymphony.xwork2.Action;

public class LoginAction implements Action {

	private String username;
	private String password;
	private String tip;
	private MyService ms;

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

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	public MyService getMs() {
		return ms;
	}

	public void setMs(MyService ms) {
		this.ms = ms;
	}

	@Override
	public String execute() throws Exception {
		if (ms.valid(getUsername(), getPassword())) {
			setTip("¹þ¹þ£¬³É¹¦");
			return SUCCESS;
		} else {
			return ERROR;
		}
	}

}
