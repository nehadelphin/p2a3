package com.bean;
public class Batch{
	int bid;
	String className;
	public Batch() {
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	@Override
	public String toString() {
		return "Batch [bid=" + bid + ", className=" + className + "]";
	}
}