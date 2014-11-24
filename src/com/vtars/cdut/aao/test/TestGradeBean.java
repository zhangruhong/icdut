package com.vtars.cdut.aao.test;

import java.util.ArrayList;
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
		for (int i = 0; i < 80; i++) {
			GradeBean gb = new GradeBean();
			gb.setCourseName("214coursename" + i);
			gb.setCredit("214credit" + i);
			gb.setGrade("214grade" + i);
			gb.setGradeRank("214GradeRank");
			gb.setGradeState("214gradeState");
			gb.setRemark("214remark");
			gb.setStudyTimes("214studyTimes");
			gb.setTeachNo("214teachNo");
			gb.setTerm("214term");
			gb.setUpdateTime("214updateTime");
			gb.setUser(user);
			gbs.add(gb);
		}
		gdao.addGrades(gbs);
	}

	@Test
	public void ShowGradesByUser() {
		ArrayList<GradeBean> grades = gdao.listGradesByUser(user);
		for (GradeBean grade : grades) {
			System.out.println("¡ª¡ª-"+grade);
		}
	}
	

	@Test 
	public void DeleteGrades() {
		gdao.deleteGrades(user);
	}

}
