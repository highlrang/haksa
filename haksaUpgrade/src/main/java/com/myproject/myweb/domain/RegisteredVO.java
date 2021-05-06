package com.myproject.myweb.domain;

public class RegisteredVO {
	private String lec_name;
	private String lec_sem;
	private String lec_maj;
	private int reg_count;
	
	private Integer user_id;
	
	public RegisteredVO() {};
	public RegisteredVO(Integer user_id, String lec_sem) {
		this.user_id = user_id;
		this.lec_sem = lec_sem;
	}
	public String getLec_name() {
		return lec_name;
	}
	public void setLec_name(String cour_name) {
		this.lec_name = cour_name;
	}
	public String getLec_sem() {
		return lec_sem;
	}
	public void setLec_sem(String lec_sem) {
		this.lec_sem = lec_sem;
	}
	public String getLec_maj() {
		return lec_maj;
	}
	public void setLec_maj(String lec_maj) {
		this.lec_maj = lec_maj;
	}
	public int getReg_count() {
		return reg_count;
	}
	public void setReg_count(int reg_count) {
		this.reg_count = reg_count;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	
	
}
