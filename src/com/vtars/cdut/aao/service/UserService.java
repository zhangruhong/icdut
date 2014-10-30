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
		// 1.级联删除用户关联的userdetail
		// String hql = "delete my_userdetail as ud where as.userdetailid=id"
		System.out.println("暂不考虑删除的事（还没学到怎么级联删除）");

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
