package com.vtars.cdut.aao.test;

import java.util.TreeMap;
import java.util.TreeSet;

import org.junit.Test;

import com.vtars.cdut.aao.Dao.FetchDao.FetchDataDao;
import com.vtars.cdut.aao.Dao.FetchDao.FetchLogin;
import com.vtars.cdut.aao.Dao.FetchDao.IFetchDataDao;
import com.vtars.cdut.aao.Model.GradeBean;

public class TestFetchDao {

	@Test
	public void fetchsessionidTest() {
		FetchLogin fl = new FetchLogin();
		boolean iscan = fl.isLoginRight("201113030214", "zhangruhong3302");
		if (iscan) {
			System.out.println("sessionid:" + fl.getSessionId());
		} else {
			System.out.println("登录失败，有sessionid也无效");
		}
	}

	@Test
	public void fetchGradesTest() {
		FetchLogin fl = new FetchLogin();
		IFetchDataDao fdao = new FetchDataDao();
		boolean iscan = fl.isLoginRight("201113030214", "zhangruhong3302");
		if (iscan) {
			TreeSet<GradeBean> grades = fdao.fetchGrades(fl.getSessionId(),
					new TreeMap<String, String>());
			if (null != grades && !grades.isEmpty()) {
				for (GradeBean grade : grades) {
					System.out.println(grade);
				}
			}
		} else {
			System.out.println("登录失败，有sessionid也无效");
		}
	}

}
