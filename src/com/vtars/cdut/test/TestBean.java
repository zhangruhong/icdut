package com.vtars.cdut.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.vtars.cdut.bean.User;
import com.vtars.cdut.bean.UserDetail;

public class TestBean {

	@Test
	public void TestAdd() {
		Session session = null;
		try {
			SessionFactory factory = new Configuration().configure()
					.buildSessionFactory();
			session = factory.openSession();
			session.beginTransaction();

			UserDetail userdetail = new UserDetail();
			userdetail.setAddress("1123");
			userdetail.setEmail("gs1df");
			userdetail.setGender(true);
			userdetail.setIdCardNo("9919999999999");
			userdetail.setNick("ni1ck");
			userdetail.setRealName("hah1je");
			userdetail.setSelfIntro("hdh1h");
			userdetail.setTel("1123");

			User user = new User();
			user.setWxid("1asadasd");
			user.setUsername("1201113030215");
			user.setPassword("1sdf");
			user.setActivestate(true);
			userdetail.setUser(user);
			user.setUserdetail(userdetail);
			session.save(user);
			session.save(userdetail);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

}
