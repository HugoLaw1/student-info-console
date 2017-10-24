package seehope.model;

import java.util.Date;

public class StudentModel {
	private String id;
	private String name;
	private int grade;
	private int classs;
	private String sex;
	private String remark;
	private String born;
	private Date createdTime;
	private Date lastUpdateTime;

	

	public StudentModel() {
		super();
	}

	public StudentModel(String id, String name,String sex, int grade, int classs) {
		super();
		this.id = id;
		this.name = name;
		this.grade = grade;
		this.classs = classs;
	}

	public StudentModel(String id, String name, int grade, int classs, String sex, String remark, String born,
			Date createdTime, Date lastUpdateTime) {
		super();
		this.id = id;
		this.name = name;
		this.grade = grade;
		this.classs = classs;
		this.sex = sex;
		this.remark = remark;
		this.born = born;
		this.createdTime = createdTime;
		this.lastUpdateTime = lastUpdateTime;
	}
	
	public StudentModel(String id, String name, int grade, int classs, String sex, String remark, String born) {
		super();
		this.id = id;
		this.name = name;
		this.grade = grade;
		this.classs = classs;
		this.sex = sex;
		this.remark = remark;
		this.born = born;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public int getClasss() {
		return classs;
	}

	public void setClasss(int classs) {
		this.classs = classs;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getBorn() {
		return born;
	}

	public void setBorn(String born) {
		this.born = born;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	@Override
	public String toString() {
		return "StudentModel [id=" + id + ", name=" + name + ", grade=" + grade + ", classs=" + classs + ", sex=" + sex
				+ ", remark=" + remark + ", born=" + born + ", createdTime=" + createdTime + ", lastUpdateTime="
				+ lastUpdateTime + "]";
	}

}
