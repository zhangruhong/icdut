package com.vtars.cdut.aao.Service;

import java.util.List;

import com.vtars.cdut.aao.Model.User;

/**
 * 此类将UserDetail一起操作了
 * 
 * @author Davisz
 *
 */
public interface IUserService {
	/**
	 * 存一个用户
	 * 
	 * @param user
	 */
	public void add(User user);

	/**
	 * 更新一个用户
	 * 
	 * @param user
	 */
	public void update(User user);

	/**
	 * 删除一个用户
	 * 
	 * @param id
	 */
	public void delete(String id);

	/**
	 * 加载一个用户（查询一个用户）
	 * 
	 * @param id
	 * @return
	 */
	public User load(String id);

	/**
	 * 列出所有的用户
	 * 
	 * @return
	 */
	public List<User> findAllUsers();

	/**
	 * 通过hql查用户
	 * 
	 * @param hql
	 * @return
	 */
	public List<User> findUsersByHql(String hql,Object[] args);

	/**
	 * 通过学号查用户
	 * 
	 * @param id
	 * @return
	 */
	public User findUserById(String id);

}
