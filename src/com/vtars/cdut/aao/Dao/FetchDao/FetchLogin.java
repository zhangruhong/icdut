package com.vtars.cdut.aao.Dao.FetchDao;

import java.io.IOException;
import java.util.Map;

import org.apache.log4j.Logger;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.Connection.Method;
import org.jsoup.nodes.Document;

import com.vtars.cdut.aao.Utils.LogUtil;

public class FetchLogin {
	private Logger logger = LogUtil.logger;
	public String sessionId = null;
	// ��һ��map��װ���ܻ���Ҫ����֤��Ϣ post��ȥ
	public Map kvinfo = null;

	@SuppressWarnings("unchecked")
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

	// �ж����� ����Ҫ���session ����������
	public boolean IsCanLogin(String uname, String upwd) {
		try {
			Connection.Response response = login(uname, upwd);
			Document doc = response.parse();

			if (doc.getElementsByTag("title").text().equals("����ҵ����Ϣ����ϵͳ[V3]")) {
				sessionId = response.cookie("PHPSESSID");
				return true;
			} else {
				logger.info("��¼ʧ��ʱ��ҳ����⣺"+doc.getElementsByTag("title").text());
				return false;
			}
		} catch (Exception e) {
			logger.error("IsCanLogin:" + e.getMessage() + e.getStackTrace());
			System.out.println("IsCanLogin:" + e.getMessage()
					+ e.getStackTrace());
			return false;
		}

	}

	public String getSessionId() {
		return sessionId;
	}

}
