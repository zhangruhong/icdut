package com.vtars.cdut.aao.Dao.UserDao;

import com.vtars.cdut.aao.Dao.IBaseDao;
import com.vtars.cdut.aao.Model.User;

public interface IUserDao extends IBaseDao<User> {
	/**
	 * 增加按学号精确查找
	 * 
	 * @return
	 */
	public User QueryUserbyid(String  id);
	// 增加其他条件查找比如按地区查找、按不精确学号查找、邮箱、手机、性别、身份证查找的通用方法
}
