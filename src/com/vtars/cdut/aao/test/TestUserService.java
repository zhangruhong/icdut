package com.vtars.cdut.aao.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vtars.cdut.aao.Model.User;
import com.vtars.cdut.aao.Model.UserDetail;
import com.vtars.cdut.aao.Service.IUserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class TestUserService {

	@Resource(name="userService")
	IUserService userService;

	/**
	 * 测试完整的添加用户以及用户信息
	 */
	@Test
	public void addUser() {
		User user = new User();
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
		userService.add(user);
	}

}
