package seehope.model;

import java.util.Date;

public class SubjectModel {
	private String sub_id;
	private String sub_name;
	private float sub_hours;
	private float sub_weight;
	private String sub_pre;
	private String sub_remark;
	private Date sub_created_time;
	private Date sub_last_update_time;
	
	
	public SubjectModel() {
		super();
	}


	public SubjectModel(String sub_id, String sub_name, float sub_hours, float sub_weight, String sub_pre) {
		super();
		this.sub_id = sub_id;
		this.sub_name = sub_name;
		this.sub_hours = sub_hours;
		this.sub_weight = sub_weight;
		this.sub_pre = sub_pre;
	}


	public String getSub_id() {
		return sub_id;
	}


	public void setSub_id(String sub_id) {
		this.sub_id = sub_id;
	}


	public String getSub_name() {
		return sub_name;
	}


	public void setSub_name(String sub_name) {
		this.sub_name = sub_name;
	}


	public float getSub_hours() {
		return sub_hours;
	}


	public void setSub_hours(float sub_hours) {
		this.sub_hours = sub_hours;
	}


	public float getSub_weight() {
		return sub_weight;
	}


	public void setSub_weight(float sub_weight) {
		this.sub_weight = sub_weight;
	}


	public String getSub_pre() {
		return sub_pre;
	}


	public void setSub_pre(String sub_pre) {
		this.sub_pre = sub_pre;
	}


	public String getSub_remark() {
		return sub_remark;
	}


	public void setSub_remark(String sub_remark) {
		this.sub_remark = sub_remark;
	}


	public Date getSub_created_time() {
		return sub_created_time;
	}


	public void setSub_created_time(Date sub_created_time) {
		this.sub_created_time = sub_created_time;
	}


	public Date getSub_last_update_time() {
		return sub_last_update_time;
	}


	public void setSub_last_update_time(Date sub_last_update_time) {
		this.sub_last_update_time = sub_last_update_time;
	}


	@Override
	public String toString() {
		return "SubjectModel [sub_id=" + sub_id + ", sub_name=" + sub_name + ", sub_hours=" + sub_hours
				+ ", sub_weight=" + sub_weight + ", sub_pre=" + sub_pre + ", sub_remark=" + sub_remark
				+ ", sub_created_time=" + sub_created_time + ", sub_last_update_time=" + sub_last_update_time + "]";
	}
	
	
}
