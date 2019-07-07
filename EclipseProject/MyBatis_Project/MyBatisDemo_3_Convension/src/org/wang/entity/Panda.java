package org.wang.entity;

public class Panda {
	
	private int stuId;
	private String stuName;
	private int stuAge;
	
	
	
	
	
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

	public int getStuAge() {
		return stuAge;
	}

	public void setStuAge(int stuAge) {
		this.stuAge = stuAge;
	}

	public Panda() {
		
	}
	
	@Override
	public String toString() {
		return "ID=" + this.stuId + "NAME=" + this.stuName + "AGE=" + this.stuAge;
	}
	
	

}
