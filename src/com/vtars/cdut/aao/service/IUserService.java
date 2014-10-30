package com.vtars.cdut.aao.service;

import java.util.List;

import com.vtars.cdut.aao.model.Pager;
import com.vtars.cdut.aao.model.User;

public interface IUserService {
	/**
	 * ��һ���û�
	 * 
	 * @param user
	 */
	public void add(User user);

	/**
	 * ����һ���û�
	 * 
	 * @param user
	 */
	public void update(User user);

	/**
	 * ɾ��һ���û�
	 * 
	 * @param id
	 */
	public void delete(int id);

	/**
	 * ����һ���û�����ѯһ���û���
	 * 
	 * @param id
	 * @return
	 */
	public User load(int id);

	/**
	 * �г����е��û�
	 * 
	 * @return
	 */
	public List<User> findAllUsers();

	/**
	 * ͨ��ѧ�Ų��û�
	 * 
	 * @param id
	 * @return
	 */
	public User findUserById(int id);

}
