package com.vtars.cdut.aao.Action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;

import com.opensymphony.xwork2.ActionSupport;
import com.vtars.cdut.aao.Model.User;
import com.vtars.cdut.aao.Service.IUserService;

public class LoginAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private String username;
	private String password;

	private IUserService userService;

	public IUserService getUserService() {
		return userService;
	}

	@Scope(value = "prototype")
	@Autowired
	@Qualifier("userService")
	public void setUserService(IUserService userService) {
		this.userService = userService;
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

	public String execute() {
		System.out.println("users_size()11");
		List<User> users = userService.findUsersByHql(
				"from User u where u.username=? and u.password=?",
				new Object[] { username, password });
		System.out.println("users_size()" + users.size());
		if (users.size() == 1) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}

}
