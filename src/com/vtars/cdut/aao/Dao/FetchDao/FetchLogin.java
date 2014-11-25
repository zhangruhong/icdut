package com.vtars.cdut.aao.Dao.FetchDao;

import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

import org.apache.log4j.Logger;
import org.jsoup.Connection;
import org.jsoup.Connection.Method;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.vtars.cdut.aao.Utils.LogUtil;

public class FetchLogin {
	private Logger logger = LogUtil.logger;
	private String sessionId = null;
	// 放一个map来装可能会需要的验证信息 post过去
	private Map<String, String> kvinfo = new TreeMap<String, String>();

	public FetchLogin() {
		super();
	}

	public String getSessionId() {
		return sessionId;
	}

	public Map<String, String> getKvinfo() {
		return kvinfo;
	}

	public void setKvinfo(Map<String, String> kvinfo) {
		this.kvinfo = kvinfo;
	}

	private Connection.Response login(String uname, String upwd) {
		Connection.Response res = null;
		kvinfo.put("uname", uname);
		kvinfo.put("upwd", upwd);
		try {
			res = Jsoup.connect("http://202.115.133.161/login.php")
					.data(kvinfo).timeout(2000).method(Method.POST).execute();
			return res;
		} catch (IOException e) {
			logger.error(e.toString());
			e.getStackTrace();
			return res;
		}
	}

	// 判断连接 不需要获得session 看返回内容
	public boolean isLoginRight(String uname, String upwd) {
		try {
			Connection.Response response = login(uname, upwd);
			Document doc = response.parse();

			if (doc.getElementsByTag("title").text().equals("教务业务信息管理系统[V3]")) {
				sessionId = response.cookie("PHPSESSID");
				return true;
			} else {
				logger.info("登录失败时的页面标题："
						+ doc.getElementsByTag("title").text());
				return false;
			}
		} catch (IOException e) {
			logger.error("isLoginRight:" + e.getMessage() + e.getStackTrace());
			System.out.println("isLoginRight:" + e.getMessage()
					+ e.getStackTrace());
			return false;
		}

	}

}
