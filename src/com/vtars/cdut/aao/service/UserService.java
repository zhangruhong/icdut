package com.vtars.cdut.aao.service;

import java.util.List;

import com.vtars.cdut.aao.Dao.UserDao.IUserDao;
import com.vtars.cdut.aao.Dao.UserDao.UserDao;
import com.vtars.cdut.aao.model.User;

//@Service("userService")
public class UserService implements IUserService {
	private IUserDao userDao=new UserDao();

	public IUserDao getUserDao() {
		return userDao;
	}

	/*@Resource*/
	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public void add(User user) {
		userDao.add(user);
	}

	@Override
	public void update(User user) {
		userDao.update(user);
	}

	@Override
	public void delete(int id) {
		// 1.����ɾ���û�������userdetail
		// String hql = "delete my_userdetail as ud where as.userdetailid=id"
		System.out.println("�ݲ�����ɾ�����£���ûѧ����ô����ɾ����");

	}

	@Override
	public User load(int id) {
		userDao.load(id);
		return userDao.load(id);
	}

	@Override
	public List<User> findAllUsers() {
		return userDao.list("");
	}

	@Override
	public User findUserById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	

	

}
