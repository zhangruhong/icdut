package com.vtars.cdut.aao.Action;

import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;

import com.opensymphony.xwork2.ActionSupport;
import com.vtars.cdut.aao.Dao.FetchDao.IFetchDataDao;
import com.vtars.cdut.aao.Service.IUserService;
import com.vtars.cdut.aao.Utils.ObjectUtil;

public class UserAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private String username;
	private String password;

	private IUserService userService;
	private IFetchDataDao fetchdatadao;

	public IUserService getUserService() {
		return userService;
	}

	@Scope(value = "prototype")
	@Autowired
	@Qualifier("userService")
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public IFetchDataDao getFetchdatadao() {
		return fetchdatadao;
	}

	@Resource(name = "fetchdatadao")
	public void setFetchdatadao(IFetchDataDao fetchdatadao) {
		this.fetchdatadao = fetchdatadao;
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

	public String userLogin() {
		if (ObjectUtil.isNullOrEmpty(username)
				|| ObjectUtil.isNullOrEmpty(password)) {
			return INPUT;
		}
		
		// ����֤�Ƿ��Ǳ���ѧ��
		Pattern pa12 = Pattern.compile("^\\d{12}$");
		Pattern pa13 = Pattern.compile("^\\d{13}$");
		boolean b12 = pa12.matcher(username).matches();
		boolean b13 = pa13.matcher(username).matches();
		if (!(b12 || b13)) {
			request.setAttribute("message",
					"��Ǹ����ʱֻ֧��12��13λ��ѧ�ţ�����˺����ͻ�û�в��Թ������ԣ�<br/>�������ϵQQ519555110���ԣ�");
			request.getRequestDispatcher("/Home/MyAAO/login.jsp").forward(
					request, response);
			return;
		}

	}

}
