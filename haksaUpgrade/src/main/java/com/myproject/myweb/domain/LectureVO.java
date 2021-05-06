package com.myproject.myweb.domain;

public class LectureVO {
	private int lec_id;
	private String lec_name;
	private String lec_sem;
	private String lec_prof;
	private String lec_time;
	
	private String lec_maj;
	
	public LectureVO() {};
	public LectureVO(String lec_name, String lec_sem) {
		this.lec_name = lec_name;
		this.lec_sem = lec_sem;
	}
	
	
	
	public int getLec_id() {
		return lec_id;
	}
	public void setLec_id(int lec_id) {
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
	public String getLec_prof() {
		return lec_prof;
	}
	public void setLec_prof(String lec_prof) {
		this.lec_prof = lec_prof;
	}
	public String getLec_time() {
		return lec_time;
	}
	public void setLec_time(String lec_time) {
		this.lec_time = lec_time;
	}
	public String getLec_maj() {
		return lec_maj;
	}
	public void setLec_maj(String lec_maj) {
		this.lec_maj = lec_maj;
	}
	
	
	
}
