package com.vtars.cdut.aao.Model;

import java.io.Serializable;

public class GradeBean implements Serializable, Comparable<Object> {
	private static final long serialVersionUID = -859905911042449857L;
	// 用户对象 学期 教学编号 课程名称 成绩 考查成绩 成绩状态 学时 学分 备注 更新时间
	private long gradeid;
	private User user;// 用户对象
	private String term;// 学期
	private String teachNo;// 教学编号
	private String courseName;// 课程编号
	private String grade;// 成绩
	private String gradeRank;// 成绩等级
	private String gradeState;// 成绩状态
	private String studyTimes;// 学时
	private String credit;// 学分
	private String remark;// 备注
	private String updateTime;// 更新时间

	public GradeBean() {
		super();
	}

	public long getGradeid() {
		return gradeid;
	}

	public void setGradeid(long gradeid) {
		this.gradeid = gradeid;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public String getTeachNo() {
		return teachNo;
	}

	public void setTeachNo(String teachNo) {
		this.teachNo = teachNo;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getGradeRank() {
		return gradeRank;
	}

	public void setGradeRank(String gradeRank) {
		this.gradeRank = gradeRank;
	}

	public String getGradeState() {
		return gradeState;
	}

	public void setGradeState(String gradeState) {
		this.gradeState = gradeState;
	}

	public String getStudyTimes() {
		return studyTimes;
	}

	public void setStudyTimes(String studyTimes) {
		this.studyTimes = studyTimes;
	}

	public String getCredit() {
		return credit;
	}

	public void setCredit(String credit) {
		this.credit = credit;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((courseName == null) ? 0 : courseName.hashCode());
		result = prime * result + ((credit == null) ? 0 : credit.hashCode());
		result = prime * result + ((grade == null) ? 0 : grade.hashCode());
		result = prime * result
				+ ((gradeRank == null) ? 0 : gradeRank.hashCode());
		result = prime * result
				+ ((gradeState == null) ? 0 : gradeState.hashCode());
		result = prime * result + ((remark == null) ? 0 : remark.hashCode());
		result = prime * result
				+ ((studyTimes == null) ? 0 : studyTimes.hashCode());
		result = prime * result + ((teachNo == null) ? 0 : teachNo.hashCode());
		result = prime * result + ((term == null) ? 0 : term.hashCode());
		result = prime * result
				+ ((updateTime == null) ? 0 : updateTime.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GradeBean other = (GradeBean) obj;
		if (courseName == null) {
			if (other.courseName != null)
				return false;
		} else if (!courseName.equals(other.courseName))
			return false;
		if (credit == null) {
			if (other.credit != null)
				return false;
		} else if (!credit.equals(other.credit))
			return false;
		if (grade == null) {
			if (other.grade != null)
				return false;
		} else if (!grade.equals(other.grade))
			return false;
		if (gradeRank == null) {
			if (other.gradeRank != null)
				return false;
		} else if (!gradeRank.equals(other.gradeRank))
			return false;
		if (gradeState == null) {
			if (other.gradeState != null)
				return false;
		} else if (!gradeState.equals(other.gradeState))
			return false;
		if (remark == null) {
			if (other.remark != null)
				return false;
		} else if (!remark.equals(other.remark))
			return false;
		if (studyTimes == null) {
			if (other.studyTimes != null)
				return false;
		} else if (!studyTimes.equals(other.studyTimes))
			return false;
		if (teachNo == null) {
			if (other.teachNo != null)
				return false;
		} else if (!teachNo.equals(other.teachNo))
			return false;
		if (term == null) {
			if (other.term != null)
				return false;
		} else if (!term.equals(other.term))
			return false;
		if (updateTime == null) {
			if (other.updateTime != null)
				return false;
		} else if (!updateTime.equals(other.updateTime))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	@Override
	public int compareTo(Object o) {
		int result = ((GradeBean) o).getUpdateTime().compareTo(
				this.getUpdateTime());
		return result == 0 ? ((GradeBean) o).getCourseName().compareTo(
				this.getCourseName()) : result; // this.getUpdateTime().compareTo(((GradeBean)o).getUpdateTime());
	}

	@Override
	public String toString() {
		return "GradeBean [Username=" + user.getUsername() + ", term=" + term
				+ ", teachNo=" + teachNo + ", courseName=" + courseName
				+ ", grade=" + grade + ", gradeRank=" + gradeRank
				+ ", gradeState=" + gradeState + ", studyTimes=" + studyTimes
				+ ", credit=" + credit + ", remark=" + remark + ", updateTime="
				+ updateTime + "]";
	}

}
