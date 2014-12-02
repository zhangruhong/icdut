package com.vtars.cdut.aao.Utils.Thread;

import java.util.Iterator;
import java.util.TreeMap;
import java.util.TreeSet;

import javax.annotation.Resource;

import org.apache.log4j.Logger;

import com.vtars.cdut.aao.Dao.FetchDao.IFetchDataDao;
import com.vtars.cdut.aao.Model.GradeBean;
import com.vtars.cdut.aao.Model.User;
import com.vtars.cdut.aao.Service.IGradeService;
import com.vtars.cdut.aao.Utils.LogUtil;

public class DownGradesThread extends Thread {
	private String sessionid = null;
	@Resource(name = "fetchdatadao")
	private IFetchDataDao fetchdatadao;
	@Resource(name = "gradeservice")
	private IGradeService gradeservice;
	private User user = null;
	private static Logger logger = LogUtil.logger;

	public DownGradesThread(String sessionid, User user) {
		this.sessionid = sessionid;
		this.user = user;
	}

	@Override
	public void run() {
		TreeSet<GradeBean> aaogbens = fetchdatadao.fetchGrades(sessionid,
				new TreeMap<String, String>());
		if (null == aaogbens || aaogbens.isEmpty())// 说明没有获取到 可能密码错 可能 官网有问题
													// 可能解析格式有问题
		{
			// TODO 想个办法阻止这种错误的继续发生 直到错误原因修正
			// 比如将该用户加入阻塞表 或 给用户自动更新状态表添标记暂停
			logger.info("该seseeion已过期：");
			return;
		}
		// 怎样将数据库中的数据与抓取到的数据做对比判断是不是最新的呢？
		GradeBean lastgb = gradeservice.queryLastDateGrades(user.getUsername());
		if (lastgb == null)// 说明该学生没有数据在数据库里面 全部拉到数据库里面去
		{
			gradeservice.addGrades(aaogbens,user);

		} else {
			TreeSet<GradeBean> tsupdate = new TreeSet<GradeBean>();
			for (Iterator<GradeBean> iterator = aaogbens.iterator(); iterator.hasNext();) {
				GradeBean gBean = (GradeBean) iterator.next();
				// 可以将该学生在数据库中最新的数据筛选出来 再将抓到的数据的时间与其相比较 较新则更新 否则抛弃
				if (gBean.getUpdateTime().compareTo(lastgb.getUpdateTime()) > 0)// gbean对于old
				{
					tsupdate.add(gBean);
				}
			}
			if (!tsupdate.isEmpty()) {
				gradeservice.addGrades(tsupdate,user);
			}
		}

	}
}
