package org.shiwei.entity;

public class Login {
	int stuId;
	String stuName;
	int password;
	
	public Login() {
		
	}
	
	public Login(int stuId, String stuName, int password) {
		super();
		this.stuId = stuId;
		this.stuName = stuName;
		this.password = password;
	}
	public int getStuId() {
		return stuId;
	}
	public void setStuId(int stuId) {
		this.stuId = stuId;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public int getPassword() {
		return password;
	}

	public void setPassword(int password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Id:" + this.stuId + "ĞÕÃû£º" + this.stuName + "ÃÜÂëÎª£º" + this.password ;
	}
	

}
