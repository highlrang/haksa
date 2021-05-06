package com.myproject.myweb.domain;

public class ScoreVO {
	private int lec_id;
	private String lec_sem;
	private String lec_name;
	private String user_name;
	private int user_id;
	private String user_major;
	
	public ScoreVO() {};
	public ScoreVO(Integer user_id, String lec_sem) {
		this.user_id = user_id;
		this.lec_sem = lec_sem;
	}
	public ScoreVO(int lec_id, int user_id) {
		this.lec_id = lec_id;
		this.user_id = user_id;
	}
	
	
	public String getLec_name() {
		return lec_name;
	}
	public void setLec_name(String cour_name) {
		this.lec_name = cour_name;
	}
	public int getLec_id() {
		return lec_id;
	}
	public void setLec_id(int lec_id) {
		this.lec_id = lec_id;
	}
	public String getLec_sem() {
		return lec_sem;
	}
	public void setLec_sem(String lec_sem) {
		this.lec_sem = lec_sem;
	}
	
	
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUser_major() {
		return user_major;
	}
	public void setUser_major(String user_major) {
		this.user_major = user_major;
	}
	
	
	
	
}
