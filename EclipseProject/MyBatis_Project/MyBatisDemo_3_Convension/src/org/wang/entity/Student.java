package org.wang.entity;

import java.io.Serializable;

//  ʵ�� ���л� ------�� ʵ��һ�� �ӿڡ�
public class Student  implements Serializable{
	private int stuNo;
	private String stuName;
	private int stuAge;
	private String graName;
	private boolean stuSex;

	public Student() {

	}

	public Student(int stuNo, String stuName, int stuAge, String graName) {
		super();
		this.stuNo = stuNo;
		this.stuName = stuName;
		this.stuAge = stuAge;
		this.graName = graName;
	}
	
	
	



	public boolean isStuSex() {
		return stuSex;
	}

	public void setStuSex(boolean stuSex) {
		this.stuSex = stuSex;
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

	public int getStuAge() {
		return stuAge;
	}

	public void setStuAge(int stuAge) {
		this.stuAge = stuAge;
	}

	public String getGraName() {
		return graName;
	}

	public void setGraName(String graName) {
		this.graName = graName;
	}

	@Override
	public String toString() {
		return "\n"+"����Ϊ:" + this.stuName + ",id�� Ϊ:" + this.stuNo + ",����Ϊ��" 
	     + this.stuAge + ",�༶Ϊ��" + this.graName + "�Ա�Ϊ:" + this.stuSex;
	}
}