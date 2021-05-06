package com.myproject.myweb.domain;

public class PagingVO {
	private int lec_id;
	
	private int nowPage, startPage, endPage, total;
	private int lastPage, start, end;
	
	private int perPage = 10;
	
	
	
	public PagingVO() {}
	public PagingVO(int lec_id, int total, int nowPage) {
		setLec_id(lec_id);
		setNowPage(nowPage);
		setTotal(total);
		
		calcLastPage(getTotal());
		calcStartEndPage(getNowPage());
		calcStartEnd(getNowPage());
	}
	public void calcLastPage(int total) { // 제일 마지막 페이지
		setLastPage((int) Math.ceil((double)total / (double)getPerPage()));
	}
	public void calcStartEndPage(int nowPage) { // 시작과 끝 페이지
		setEndPage((int) Math.ceil((double)nowPage / (double)getPerPage()) * getPerPage());
		if (getLastPage() < getEndPage()) {
			setEndPage(getLastPage());
		}
		setStartPage(getEndPage() - getPerPage() + 1);
		if (getStartPage() < 1) {
			setStartPage(1);
		}
	}
	public void calcStartEnd(int nowPage) { // DB용 start, end
		setEnd(nowPage * getPerPage());
		setStart(getEnd() - getPerPage() + 1);
	}
	
	
	
	
	
	
	public int getLec_id() {
		return lec_id;
	}
	public void setLec_id(int lec_id) {
		this.lec_id = lec_id;
	}
	
	
	public int getNowPage() {
		return nowPage;
	}
	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getPerPage() {
		return perPage;
	}
	public void setPerPage(int perPage) {
		this.perPage = perPage;
	}
	public int getLastPage() {
		return lastPage;
	}
	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	
	
	
	
	
}
