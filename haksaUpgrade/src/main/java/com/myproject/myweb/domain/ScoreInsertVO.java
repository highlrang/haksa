package com.myproject.myweb.domain;

public class ScoreInsertVO {
	private int user_id;
	private int lec_id;
	private int res_reg;
	private int mid_exam;
	private int final_exam;
	private int assignment;
	private int attendence;
	
	public ScoreInsertVO() {};

	
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getLec_id() {
		return lec_id;
	}
	public void setLec_id(int lec_id) {
		this.lec_id = lec_id;
	}

	public int getRes_reg() {
		return res_reg;
	}


	public void setRes_reg(int res_reg) {
		this.res_reg = res_reg;
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
	
	
	
}
