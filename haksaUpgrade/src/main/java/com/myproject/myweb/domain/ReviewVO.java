package com.myproject.myweb.domain;

public class ReviewVO {
	private int lec_id;
	private String lec_name;
	private int user_id;
	
	private int rev_stars;
	private String rev_content;
	private int rev_public;
	private String rev_keyword;
	
	public ReviewVO() {}
	public ReviewVO(Integer user_id, String lec_name) {
		this.user_id = user_id;
		this.lec_name = lec_name;
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
	
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
	public int getRev_stars() {
		return rev_stars;
	}

	public void setRev_stars(int rev_stars) {
		this.rev_stars = rev_stars;
	}

	public String getRev_content() {
		return rev_content;
	}

	public void setRev_content(String rev_content) {
		this.rev_content = rev_content;
	}

	public int getRev_public() {
		return rev_public;
	}

	public void setRev_public(int rev_public) {
		this.rev_public = rev_public;
	}


	public String getRev_keyword() {
		return rev_keyword;
	}


	public void setRev_keyword(String rev_keyword) {
		this.rev_keyword = rev_keyword;
	}
	
	
	
}
