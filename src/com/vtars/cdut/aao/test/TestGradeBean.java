package com.vtars.cdut.aao.test;

import java.util.TreeSet;

import javax.annotation.Resource;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vtars.cdut.aao.Dao.GradeDao.IGradeDao;
import com.vtars.cdut.aao.Model.GradeBean;
import com.vtars.cdut.aao.Model.User;
import com.vtars.cdut.aao.Model.UserDetail;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class TestGradeBean {

	@Resource
	IGradeDao gdao;

	private static User user;
	private static UserDetail ud;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

		user = new User();
		user.setUsername("201113");
		user.setPassword("asgdfos");
		user.setWxid("jaghsdfjkh");
		user.setActivestate(true);
		UserDetail uDetail = new UserDetail();
		uDetail.setAddress("1234");
		uDetail.setEmail("jgasdh@sdf.com");
		uDetail.setGender(true);
		uDetail.setIdCardNo("qwe5r");
		uDetail.setNick("asdfnick");
		uDetail.setRealName("realname");
		uDetail.setSelfIntro("selfintro");
		uDetail.setTel("tel");
		uDetail.setUser(user);
		user.setUserdetail(uDetail);

	}

	@Test
	public void addGrades() {
		TreeSet<GradeBean> gbs = new TreeSet<GradeBean>();
		for (int i = 0; i < 50; i++) {
			GradeBean gb = new GradeBean();
			gb.setCourseName("coursename" + i);
			gb.setCredit("credit" + i);
			gb.setGrade("grade" + i);
			gb.setGradeRank("GradeRank");
			gb.setGradeState("gradeState");
			gb.setRemark("remark");
			gb.setStudyTimes("studyTimes");
			gb.setTeachNo("teachNo");
			gb.setTerm("term");
			gb.setUpdateTime("updateTime");
			gb.setUser(user);
			gbs.add(gb);
		}
		gdao.AddGrades(gbs);
	}

}
