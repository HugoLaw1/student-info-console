package seehope.model;

import java.util.Map;

public class MarkModel {
	private String id;
	private String name;
	private int grade;
	private int classs;
	private String subject1_mark;
	private String subject2_mark;
	private String subject3_mark;
	private String subject4_mark;
	private String subject5_mark;
	private String subject6_mark;
	
	public MarkModel() {
		super();
	}

	public MarkModel(String id, String name, int grade, int classs) {
		super();
		this.id = id;
		this.name = name;

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

	public String getSubject1_mark() {
		return subject1_mark;
	}

	public void setSubject1_mark(String subject1_mark) {
		this.subject1_mark = subject1_mark;
	}

	public String getSubject2_mark() {
		return subject2_mark;
	}

	public void setSubject2_mark(String subject2_mark) {
		this.subject2_mark = subject2_mark;
	}

	public String getSubject3_mark() {
		return subject3_mark;
	}

	public void setSubject3_mark(String subject3_mark) {
		this.subject3_mark = subject3_mark;
	}

	public String getSubject4_mark() {
		return subject4_mark;
	}

	public void setSubject4_mark(String subject4_mark) {
		this.subject4_mark = subject4_mark;
	}

	public String getSubject5_mark() {
		return subject5_mark;
	}

	public void setSubject5_mark(String subject5_mark) {
		this.subject5_mark = subject5_mark;
	}

	public String getSubject6_mark() {
		return subject6_mark;
	}

	public void setSubject6_mark(String subject6_mark) {
		this.subject6_mark = subject6_mark;
	}

	@Override
	public String toString() {
		return "MarkModel [id=" + id + ", name=" + name + ", grade=" + grade + ", classs=" + classs + ", subject1_mark="
				+ subject1_mark + ", subject2_mark=" + subject2_mark + ", subject3_mark=" + subject3_mark
				+ ", subject4_mark=" + subject4_mark + ", subject5_mark=" + subject5_mark + ", subject6_mark="
				+ subject6_mark + "]";
	}
	
	
	
}	
