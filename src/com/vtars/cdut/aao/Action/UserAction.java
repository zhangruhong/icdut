package com.vtars.cdut.aao.Action;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.ServletContextAware;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RegexFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.StringLengthFieldValidator;
import com.opensymphony.xwork2.validator.annotations.Validation;
import com.opensymphony.xwork2.validator.annotations.Validations;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;
import com.vtars.cdut.aao.Dao.FetchDao.FetchLogin;
import com.vtars.cdut.aao.Dao.FetchDao.IFetchDataDao;
import com.vtars.cdut.aao.Service.IUserService;

public class UserAction extends ActionSupport implements Action,
		ServletContextAware, ServletRequestAware, ServletResponseAware {

	private static final long serialVersionUID = 2741633550359039144L;
	private String username;
	private String password;
	private ServletContext context;
	private HttpServletResponse response;
	private HttpServletRequest request;

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
		// FetchLogin fl = new FetchLogin();
		// boolean isRight = fl.isLoginRight(username, password);
		// if (!isRight) {
		// return INPUT;
		// // �Ӹ���ʾ �˺����벻ƥ��
		// }
		// String sessionid = fl.getSessionId();
		// // ��aaosession���õ�session��
		// request.getSession().setAttribute("aaosession", sessionid);
		String aString = username + password;
		System.out.println(aString);
		return SUCCESS;

		/*
		 * // ��������һ����֤�Ƿ����δ���۵ĺ��� ArrayList<String> al =
		 * CheckExitsNoEvaluate(lw.getSessionId()); if (al != null && al.size()
		 * > 1) { System.out.println("δ���۴�����Ը���:" + username);
		 * request.setAttribute("al", al);
		 * request.getRequestDispatcher("/Home/waitEvaluateList.jsp").forward(
		 * request, response); return; } // �鿴�Ƿ���ڸ��û� /������������� userbean user =
		 * us.UserExistCheck(username); if (null == user) // �������򴴽����û� {
		 * us.addUser(username, password); logger.info("��ӭ���û���" + username);
		 * 
		 * // ���´�����Ϊ�˼���ifesle�����ӵ� ��Ϊ������ͨ���� user = new userbean();
		 * user.setStudyid(username); user.setPassword(password);
		 * user.setActive(false); }
		 * 
		 * // ����ϵͳ��������վ���ݲ�ͬ ���� if (!user.getPassword().equals(password.trim()))
		 * { us.UpdataPassword(username, password);
		 * logger.info("����ϵͳ��������վ���ݲ�ͬ!ִ�и���"); }
		 * 
		 * // �ߵ����� ˵���Ѿ���¼�ɹ���
		 * 
		 * // ����Ӧ������һ���߳̽��ɼ�down�����浽���ݿ� DownGradesThread dgt = new
		 * DownGradesThread(aaosession, user); dgt.start();
		 * 
		 * request.getSession(true).setAttribute("user", user); Calendar nowtime
		 * = Calendar.getInstance(); SimpleDateFormat format = new
		 * SimpleDateFormat("yyyy-MM-dd-HH-mm"); String time =
		 * format.format(nowtime.getTime());
		 * request.getSession().setAttribute("logintime", time);
		 * 
		 * 
		 * // ����û��Ƿ��Ѽ��� if (false == user.isActive()) { // N ת������Ϣ��ȫ����
		 * request.setAttribute("user", user);
		 * request.getRequestDispatcher("/Home/LinkwithEmail.jsp")
		 * .forward(request, response); return; }
		 *//**
		 * ���ö�˵���۵�¼cookie ����ʱ��2��
		 */
		/*
		 * String showname = (user.getNick() == null ||
		 * "".equals(user.getNick())) ? username : user.getNick(); Cookie
		 * duoshuoCookie = new Cookie("duoshuo_token", LocalComment.dojwt(
		 * username, showname)); duoshuoCookie.setMaxAge(60 * 60 * 24 * 2);
		 * duoshuoCookie.setPath(request.getContextPath());
		 * response.addCookie(duoshuoCookie);
		 * response.sendRedirect(request.getContextPath() +
		 * "/Home/MyAAO/index.jsp");
		 */

	}

	@Override
	public void setServletContext(ServletContext context) {
		this.context = context;
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

}
