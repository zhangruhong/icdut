package com.vtars.cdut.aao.Dao.FetchDao;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeSet;

import com.vtars.cdut.aao.Model.GradeBean;

public interface IFetchDataDao {

	/**
	 * 获取成绩页面 解析数据
	 * 
	 * @param aaosessionid
	 *            教务系统的sessionid 你懂的
	 * @param kvinfo
	 *            变态的暗码验证
	 * @return 
	 */
	public TreeSet<GradeBean> fetchGrades(String aaosessionid, Map<String, String> kvinfo);

	/**
	 * 老系统的新闻详情页 与登录无关
	 * 
	 * @param newsurl
	 * @return
	 */
	public String fetchNewsContent(String newsurl);

	/**
	 * 老系统的新闻列表页
	 * 
	 * @param AAO_URL
	 * @return
	 */
	public Map<String, String> fetchNewsUrls(String AAO_URL);

	/**
	 * 检查是否存在未评论的成绩
	 * @param sessionId
	 * @return
	 */
	public ArrayList<String> CheckExitsNoEvaluate(String sessionId);

}
