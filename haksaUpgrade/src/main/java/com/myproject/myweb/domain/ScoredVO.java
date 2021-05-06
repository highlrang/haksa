package com.myproject.myweb.domain;

public class ScoredVO {
	private int user_id;
	private String user_password;
	
	private String lec_name;
	private String lec_sem;
	private String lec_maj;
	
	private int mid_exam;
	private int final_exam;
	private int assignment;
	private int attendence;
	private int res_score;
	private String res_grade;
	
	private int reg_stu;
	
	public ScoredVO() {}
	
	
	
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}


	public String getLec_name() {
		return lec_name;
	}

	public void setLec_name(String cour_name) {
		this.lec_name = cour_name;
	}
	public String getLec_maj() {
		return lec_maj;
	}
	public void setLec_maj(String lec_maj) {
		this.lec_maj = lec_maj;
	}
	public String getLec_sem() {
		return lec_sem;
	}
	public void setLec_sem(String lec_sem) {
		this.lec_sem = lec_sem;
	}
	
	
	
	
	public int getMid_exam() {
		return mid_exam;
	}
	public void setMid_exam(int mid_exam) {
		this.mid_exam = mid_exam;
	}
	public int getFinal_exam() {
		return final_exam;
	}
	public void setFinal_exam(int final_exam) {
		this.final_exam = final_exam;
	}
	public int getAssignment() {
		return assignment;
	}
	public void setAssignment(int assignment) {
		this.assignment = assignment;
	}
	public int getAttendence() {
		return attendence;
	}
	public void setAttendence(int attendence) {
		this.attendence = attendence;
	}
	public int getRes_score() {
		return res_score;
	}
	
	public void setRes_score(int score) {
		this.res_score = score;
	}

	public String getRes_grade() {
		return res_grade;
	}

	public void setRes_grade(String grade) {
		this.res_grade = grade;
	}

	
	
	
	
	public int getReg_stu() {
		return reg_stu;
	}

	public void setReg_stu(int reg_stu) {
		this.reg_stu = reg_stu;
	}
	
	
	
	
	
}
