package org.wang.entity;

public class Mouse {
	private int stuNo;
	private String stuName;
	private int classId;
	
	public Mouse() {
		// TODO Auto-generated constructor stub
	}

	public int getStuNo() {
		return stuNo;
	}

	public void setStuNo(int stuNo) {
		this.stuNo = stuNo;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}
	
	@Override
	public String toString() {
		return "stuId=" + this.stuNo + "\tstuName=" + this.stuName;
	}
	

}
