package com.vtars.cdut.aao.Dao.UserDetailDao;

import org.springframework.stereotype.Repository;

import com.vtars.cdut.aao.Dao.BaseDao;
import com.vtars.cdut.aao.model.UserDetail;

@Repository("userdetailDao")
public class UserDetailDao extends BaseDao<UserDetail> implements
		IUserDetailDao {
}
