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
		// // 加个提示 账号密码不匹配
		// }
		// String sessionid = fl.getSessionId();
		// // 将aaosession设置到session里
		// request.getSession().setAttribute("aaosession", sessionid);
		String aString = username + password;
		System.out.println(aString);
		return SUCCESS;

		/*
		 * // 这里增加一个验证是否存在未评价的函数 ArrayList<String> al =
		 * CheckExitsNoEvaluate(lw.getSessionId()); if (al != null && al.size()
		 * > 1) { System.out.println("未评价处理调试跟踪:" + username);
		 * request.setAttribute("al", al);
		 * request.getRequestDispatcher("/Home/waitEvaluateList.jsp").forward(
		 * request, response); return; } // 查看是否存在该用户 /存在则更新密码 userbean user =
		 * us.UserExistCheck(username); if (null == user) // 不存在则创建新用户 {
		 * us.addUser(username, password); logger.info("欢迎新用户：" + username);
		 * 
		 * // 以下纯属是为了减少ifesle而增加的 即为了增加通用性 user = new userbean();
		 * user.setStudyid(username); user.setPassword(password);
		 * user.setActive(false); }
		 * 
		 * // 教务系统数据与网站数据不同 更新 if (!user.getPassword().equals(password.trim()))
		 * { us.UpdataPassword(username, password);
		 * logger.info("教务系统数据与网站数据不同!执行更新"); }
		 * 
		 * // 走到这里 说明已经登录成功了
		 * 
		 * // 这里应该启动一个线程将成绩down下来存到数据库 DownGradesThread dgt = new
		 * DownGradesThread(aaosession, user); dgt.start();
		 * 
		 * request.getSession(true).setAttribute("user", user); Calendar nowtime
		 * = Calendar.getInstance(); SimpleDateFormat format = new
		 * SimpleDateFormat("yyyy-MM-dd-HH-mm"); String time =
		 * format.format(nowtime.getTime());
		 * request.getSession().setAttribute("logintime", time);
		 * 
		 * 
		 * // 检查用户是否已激活 if (false == user.isActive()) { // N 转发到信息不全界面
		 * request.setAttribute("user", user);
		 * request.getRequestDispatcher("/Home/LinkwithEmail.jsp")
		 * .forward(request, response); return; }
		 *//**
		 * 设置多说评论登录cookie 过期时间2天
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
