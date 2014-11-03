package com.vtars.cdut.aao.test;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.vtars.cdut.aao.Dao.UserDao.IUserDao;
import com.vtars.cdut.aao.Dao.UserDetailDao.IUserDetailDao;
import com.vtars.cdut.aao.Model.User;
import com.vtars.cdut.aao.Model.UserDetail;
import com.vtars.cdut.aao.Service.IUserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class TestUserDao {

	@Resource
	IUserDao userDao;
	@Resource
	IUserDetailDao userdetaiDao;
	
	@Test
	public void addtestadd() {

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

		userDao.add(user);
		userdetaiDao.add(uDetail);
	}

	@Test
	@Transactional
	// 注意删除UserDao的@Transactional
	public void testshowaUser() {
		List<User> users = userDao
				.list("from User u where u.username='201113030214'");
		for (User user : users) {
			System.out.println(user.getPassword() + "---" + user.getWxid());
		}
	}

	@Test
	@Transactional
	public void testShowAllUsers() {
		List<User> users = userDao.list("from User");
		System.out.println("---------------testShowAllUsers:");
		for (User user : users) {
			System.out.println(user.getUsername() + "=========="
					+ user.getPassword());
		}
	}

	@Test
	@Transactional
	public void testfindUserdetailByUser() {
		UserDetail ud = userDao
				.list("from User as u where u.username='201113030214'").get(0)
				.getUserdetail();
		System.out.println("------------------testfindByUserdetail");
		System.out.println(ud.getAddress() + "--------" + ud.getUserDetailid());
	}

	@Test
	@Transactional
	// 注意删除UserDao的@Transactional
	public void testfindUserbyid() {
		User user = userDao.QueryUserbyid("201113030214");
		System.out.println("testfindUserbyid:" + user);
	}

	@Test
	// 添加了事务后不能更新
	public void updateUserinfo() {
		User user = userDao.QueryUserbyid("201113030214");
		System.out.println("updateUserinfo1:" + user);
		user.setPassword("123123123");
		user.setActivestate(false);
		userDao.update(user);
		System.out.println("updateUserinfo2:" + user);
	}

	@Test
	public void updateUserDetailinfo() {
		User user = userDao.QueryUserbyid("201113030214");
		System.out.println("updateUserinfo1:" + user);
		user.getUserdetail().setAddress("addresssdf");
		user.setPassword("123sdf3sd");
		user.getUserdetail().setRealName("zhaSduh1");
		user.setActivestate(true);
		userDao.update(user);
		userdetaiDao.update(user.getUserdetail());
		System.out.println("updateUserinfo2:" + user);
	}

	@Test
	public void deleteUserAndUserDetail() {
		userDao.delete("2011130302141");
		userdetaiDao.delete("2011130302141");
	}
}
