package com.vtars.cdut.aao.Dao.UserDao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vtars.cdut.aao.Dao.BaseDao;
import com.vtars.cdut.aao.model.User;

@Repository("userDao")
public class UserDao extends BaseDao<User> implements IUserDao {
}
