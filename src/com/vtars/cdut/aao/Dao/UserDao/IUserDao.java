package com.vtars.cdut.aao.Dao.UserDao;

import com.vtars.cdut.aao.Dao.IBaseDao;
import com.vtars.cdut.aao.Model.User;

public interface IUserDao extends IBaseDao<User> {
	/**
	 * ���Ӱ�ѧ�ž�ȷ����
	 * 
	 * @return
	 */
	public User QueryUserbyid(String  id);
	// ���������������ұ��簴�������ҡ�������ȷѧ�Ų��ҡ����䡢�ֻ����Ա����֤���ҵ�ͨ�÷���
}
