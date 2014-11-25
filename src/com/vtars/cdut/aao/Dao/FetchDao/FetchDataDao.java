package com.vtars.cdut.aao.Dao.FetchDao;

import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeSet;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.vtars.cdut.aao.Model.GradeBean;
import com.vtars.cdut.aao.Utils.LogUtil;

public class FetchDataDao implements IFetchDataDao {
	private static Logger logger = LogUtil.logger;

	@Override
	public TreeSet<GradeBean> fetchGrades(String aaosessionid,
			Map<String, String> kvinfo) {
		// Loginweb.getInstance("201113030214","zhangruhong3302");
		// 这儿的SESSIONID需要根据要登录的目标网站设置的session Cookie名字而定

		TreeSet<GradeBean> courseList = null;
		try {
			String urlString = "http://202.115.133.161/sys_xj_xscj/sys_xj_xscj.php";
			logger.info("aaosessionid:" + aaosessionid);
			Document objectDoc = Jsoup.connect(urlString)
					.cookie("PHPSESSID", aaosessionid).data(kvinfo)
					.timeout(2000).get();
			courseList = new TreeSet<GradeBean>();
			Elements trElements = null;

			trElements = (objectDoc.getElementsByTag("tbody").get(0).children());

			for (Iterator<Element> iterator = trElements.iterator(); iterator
					.hasNext();) {
				GradeBean gb = new GradeBean();
				Element element = (Element) iterator.next();
				Elements tdElements = element.children();

				gb.setTerm(tdElements.get(0).text());
				gb.setTeachNo(tdElements.get(1).text());
				gb.setCourseName(tdElements.get(2).text());
				gb.setGrade(tdElements.get(3).text());
				gb.setGradeRank(tdElements.get(4).text());
				gb.setGradeState(tdElements.get(5).text());
				gb.setStudyTimes(tdElements.get(6).text());
				gb.setCredit(tdElements.get(7).text());
				gb.setRemark(tdElements.get(8).text());
				gb.setUpdateTime(tdElements.get(9).text());
				courseList.add(gb);
				System.out.println("fetchGrades:"+gb);
			}
			// 删除最后的表头
			courseList.remove(courseList.first());
			return courseList;// 成功登录
		} catch (IOException e) {
			logger.error("GetDateDaoImpl:" + e.getStackTrace() + e.getMessage());
			return courseList;
		}
	}

	@Override
	public String fetchNewsContent(String newsurl) {
		Elements elements = null;
		try {
			Document doc = Jsoup.connect(newsurl).get();
			elements = doc.select("#text");
			Elements Ehref = elements.select("a[href]");
			for (Element element : Ehref) {
				element.attr("href", element.attr("abs:href"));
			}

			elements.select("img[src]").remove();
			// 如果有表格 设置表格属性 使尽量不越界
			elements.select("table").attr("cellspacing", "0")
					.attr("cellpadding", "0");
			elements.select("table").attr("style",
					"width:100%; font-size:12px;border-collapse:collapse");
			elements.select("table").attr("width", "70px");
			return elements.toString();
		} catch (IOException e) {
			logger.error(e);
			return null;
		}
	}

	@Override
	public Map<String, String> fetchNewsUrls(String AAO_URL) {
		// "http://www.aao.cdut.edu.cn/aao/aao.php?sort=389&sorid=391&from=more"
		try {
			LinkedHashMap<String, String> tm = new LinkedHashMap<String, String>();
			Document doc = Jsoup.connect(AAO_URL).get();
			Elements es = doc.select("td[height=20]").select("a[title]");
			for (Element element : es) {
				tm.put(element.text(), element.attr("abs:href"));
			}
			return tm;
		} catch (IOException e) {
			logger.error(e.getMessage());
			return null;
		}

	}

}
