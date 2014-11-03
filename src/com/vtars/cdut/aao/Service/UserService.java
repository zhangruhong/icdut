package com.vtars.cdut.aao.Service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vtars.cdut.aao.Dao.UserDao.IUserDao;
import com.vtars.cdut.aao.Dao.UserDetailDao.IUserDetailDao;
import com.vtars.cdut.aao.Model.User;

@Service("userService")
public class UserService implements IUserService {
	private IUserDao userDao;
	private IUserDetailDao userdetailDao;

	public IUserDao getUserDao() {
		return userDao;
	}

	@Resource(name = "userDao")
	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	public IUserDetailDao getUserdetailDao() {
		return userdetailDao;
	}

	@Resource(name = "userdetailDao")
	public void setUserdetailDao(IUserDetailDao userdetailDao) {
		this.userdetailDao = userdetailDao;
	}

	@Override
	public void add(User user) {
		userDao.add(user);
		userdetailDao.add(user.getUserdetail());
	}

	@Override
	public void update(User user) {
		userDao.update(user);
		userdetailDao.update(user.getUserdetail());
	}

	@Override
	public void delete(String id) {
		// 1.级联删除用户关联的userdetail
		// String hql = "delete my_userdetail as ud where as.userdetailid=id"
		userDao.delete("2011130302141");
		userdetailDao.delete("2011130302141");
		System.out.println("这里做得不够好，应该改为级联删除");
	}

	@Override
	public User load(String id) {
		userDao.load(id);
		return userDao.load(id);
	}

	@Override
	public List<User> findAllUsers() {
		return userDao.list("from User");
	}

	@Override
	public User findUserById(String id) {
		return userDao.QueryUserbyid(id);
	}

}
