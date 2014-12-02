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
		if (null == aaogbens || aaogbens.isEmpty())// ˵��û�л�ȡ�� ��������� ���� ����������
													// ���ܽ�����ʽ������
		{
			// TODO ����취��ֹ���ִ���ļ������� ֱ������ԭ������
			// ���罫���û����������� �� ���û��Զ�����״̬��������ͣ
			logger.info("��seseeion�ѹ��ڣ�");
			return;
		}
		// ���������ݿ��е�������ץȡ�����������Ա��ж��ǲ������µ��أ�
		GradeBean lastgb = gradeservice.queryLastDateGrades(user.getUsername());
		if (lastgb == null)// ˵����ѧ��û�����������ݿ����� ȫ���������ݿ�����ȥ
		{
			gradeservice.addGrades(aaogbens,user);

		} else {
			TreeSet<GradeBean> tsupdate = new TreeSet<GradeBean>();
			for (Iterator<GradeBean> iterator = aaogbens.iterator(); iterator.hasNext();) {
				GradeBean gBean = (GradeBean) iterator.next();
				// ���Խ���ѧ�������ݿ������µ�����ɸѡ���� �ٽ�ץ�������ݵ�ʱ��������Ƚ� ��������� ��������
				if (gBean.getUpdateTime().compareTo(lastgb.getUpdateTime()) > 0)// gbean����old
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
