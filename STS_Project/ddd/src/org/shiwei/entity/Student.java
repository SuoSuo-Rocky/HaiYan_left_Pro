package org.shiwei.entity;

public class Student {
	private int stuId;
	private String stuName;
	private int stuGender;
	private int stuAge;
	private int stuRank;
	private String stuDepartment;
	
	public Student() {
		
		
	}
	
	

	public Student(int stuId, String stuName, int stuGender, int stuAge, int stuRank, String stuDepartment) {
		super();
		this.stuId = stuId;
		this.stuName = stuName;
		this.stuGender = stuGender;
		this.stuAge = stuAge;
		this.stuRank = stuRank;
		this.stuDepartment = stuDepartment;
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

	public int getStuGender() {
		return stuGender;
	}

	public void setStuGender(int stuGender) {
		this.stuGender = stuGender;
	}

	public int getStuAge() {
		return stuAge;
	}

	public void setStuAge(int stuAge) {
		this.stuAge = stuAge;
	}

	public int getStuRank() {
		return stuRank;
	}

	public void setStuRank(int stuRank) {
		this.stuRank = stuRank;
	}

	public String getStuDepartment() {
		return stuDepartment;
	}

	public void setStuDepartment(String stuDepartment) {
		this.stuDepartment = stuDepartment;
	}
	
	
	
	

}
