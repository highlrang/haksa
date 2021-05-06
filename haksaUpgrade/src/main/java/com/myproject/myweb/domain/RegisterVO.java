package com.myproject.myweb.domain;

public class RegisterVO {
	private Integer user_id;
	private Integer lec_id;
	private String lec_name;
	private String lec_sem;
	
	private Integer reg_count;
	private Integer lec_limit;
	
	public RegisterVO() {};
	public RegisterVO(Integer user_id, String lec_name, String lec_sem, Integer reg_count) {
		this.user_id = user_id;
		this.lec_name = lec_name;
		this.lec_sem = lec_sem;
		this.reg_count = reg_count;
	}
	public RegisterVO(String lec_name, String lec_sem) {
		this.lec_name = lec_name;
		this.lec_sem = lec_sem;
	}
	public RegisterVO(Integer user_id, Integer lec_id) {
		this.user_id = user_id;
		this.lec_id = lec_id;
	}
	
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	
	public Integer getLec_id() {
		return lec_id;
	}

	public void setLec_id(Integer lec_id) {
		this.lec_id = lec_id;
	}

	public String getLec_name() {
		return lec_name;
	}
	public void setLec_name(String lec_name) {
		this.lec_name = lec_name;
	}
	public String getLec_sem() {
		return lec_sem;
	}
	public void setLec_sem(String lec_sem) {
		this.lec_sem = lec_sem;
	}
	
	
	public Integer getReg_count() {
		return reg_count;
	}
	public void setReg_count(Integer reg_count) {
		this.reg_count = reg_count;
	}
	public Integer getLec_limit() {
		return lec_limit;
	}
	public void setLec_limit(Integer lec_limit) {
		this.lec_limit = lec_limit;
	}
	
	
	
}
