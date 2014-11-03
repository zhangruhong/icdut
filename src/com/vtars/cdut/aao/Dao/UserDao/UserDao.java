package com.vtars.cdut.aao.Dao.UserDao;

import org.springframework.stereotype.Repository;

import com.vtars.cdut.aao.Dao.BaseDao;
import com.vtars.cdut.aao.Model.User;

@Repository("userDao")
public class UserDao extends BaseDao<User> implements IUserDao {

	@Override
	public User QueryUserbyid(String id) {
		return this.getHibernateTemplate().get(User.class, id);
	}
}
