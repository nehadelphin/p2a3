package com.bean;
public class Participant {
	public int pid;
	public String name;
	public String email;
	public Participant(){
	}
	public Participant(int pid, String name, String email) {
		this.pid = pid;
		this.name = name;
		this.email = email;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Participant [pid=" + pid + ", name=" + name + ", email=" + email + "]";
	}
}