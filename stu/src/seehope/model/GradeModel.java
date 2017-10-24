package seehope.model;

import java.util.Date;

public class GradeModel {
	private String id;
	private int grade;
	private String subject1;
	private String subject2;
	private String subject3;
	private String subject4;
	private String subject5;
	private String subject6;

	private Date createdTime;
	private Date LastUpdateTime;

	public GradeModel() {
		super();
	}

	public GradeModel(String id, int grade, String subject1, String subject2, String subject3, String subject4,
			String subject5, String subject6) {
		super();
		this.id = id;
		this.grade = grade;
		this.subject1 = subject1;
		this.subject2 = subject2;
		this.subject3 = subject3;
		this.subject4 = subject4;
		this.subject5 = subject5;
		this.subject6 = subject6;
	}

	public GradeModel(int grade, String subject1, String subject2, String subject3, String subject4, String subject5,
			String subject6) {
		super();
		this.grade = grade;
		this.subject1 = subject1;
		this.subject2 = subject2;
		this.subject3 = subject3;
		this.subject4 = subject4;
		this.subject5 = subject5;
		this.subject6 = subject6;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public String getSubject1() {
		return subject1;
	}

	public void setSubject1(String subject1) {
		this.subject1 = subject1;
	}

	public String getSubject2() {
		return subject2;
	}

	public void setSubject2(String subject2) {
		this.subject2 = subject2;
	}

	public String getSubject3() {
		return subject3;
	}

	public void setSubject3(String subject3) {
		this.subject3 = subject3;
	}

	public String getSubject4() {
		return subject4;
	}

	public void setSubject4(String subject4) {
		this.subject4 = subject4;
	}

	public String getSubject5() {
		return subject5;
	}

	public void setSubject5(String subject5) {
		this.subject5 = subject5;
	}

	public String getSubject6() {
		return subject6;
	}

	public void setSubject6(String subject6) {
		this.subject6 = subject6;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public Date getLastUpdateTime() {
		return LastUpdateTime;
	}

	public void setLastUpdateTime(Date lastUpdateTime) {
		LastUpdateTime = lastUpdateTime;
	}

	@Override
	public String toString() {
		return "GradeModel [id=" + id + ", grade=" + grade + ", subject1=" + subject1 + ", subject2=" + subject2
				+ ", subject3=" + subject3 + ", subject4=" + subject4 + ", subject5=" + subject5 + ", subject6="
				+ subject6 + ", createdTime=" + createdTime + ", LastUpdateTime=" + LastUpdateTime + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return false;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GradeModel objtemp = (GradeModel) obj;
		boolean tgrade = (objtemp.getGrade() == this.getGrade());
		boolean t1 = objtemp.getSubject1().equals(this.getSubject1());
		boolean t2 = objtemp.getSubject2().equals(this.getSubject2());
		boolean t3 = objtemp.getSubject3().equals(this.getSubject3());
		boolean t4 = objtemp.getSubject4().equals(this.getSubject4());
		boolean t5 = objtemp.getSubject5().equals(this.getSubject5());
		boolean t6 = objtemp.getSubject6().equals(this.getSubject6());

		if (tgrade && t1 && t2 && t3 && t4 && t5 && t6) {
			return true;
		}
		return false;
	}

}
