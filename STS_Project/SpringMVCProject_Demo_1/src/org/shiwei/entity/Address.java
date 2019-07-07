package org.shiwei.entity;

public class Address {
	private String homeAddress;
	private String schoolAddress;
	public String getHomeAddress() {
		return homeAddress;
	}
	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}
	public String getSchoolAddress() {
		return schoolAddress;
	}
	public void setSchoolAddress(String schoolAddress) {
		this.schoolAddress = schoolAddress;
	}
	
	@Override
	public String toString() {
		return "\t家庭地址为：" + this.homeAddress + "\t学校地址为：" + this.schoolAddress;
	}

}
