package com.vtars.cdut.aao.Service;

import java.util.ArrayList;
import java.util.TreeSet;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.vtars.cdut.aao.Dao.GradeDao.IGradeDao;
import com.vtars.cdut.aao.Model.GradeBean;
import com.vtars.cdut.aao.Model.User;

@Repository("gradeservice")
public class GradeService implements IGradeService {

	@Resource(name = "gdao")
	private IGradeDao gdao;

	@Override
	public void addGrades(TreeSet<GradeBean> ts,User u) {
		gdao.addGrades(ts,u);

	}

	@Override
	public void deleteGrades(User user) {
		gdao.deleteGrades(user);
	}

	@Override
	public ArrayList<GradeBean> listGradesByUser(User u) {
		return gdao.listGradesByUser(u);
	}

	@Override
	public ArrayList<GradeBean> queryByHql(String hql, Object[] args) {
		return gdao.queryByHql(hql, args);
	}

	@Override
	public GradeBean queryLastDateGrades(String username) {
		return gdao.queryLastDateGrades(username);
	}

}
