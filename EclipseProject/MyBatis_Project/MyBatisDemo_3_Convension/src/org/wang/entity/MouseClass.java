package org.wang.entity;

import java.util.List;

public class MouseClass {
	
	private int classId;
	private String className;
	
	//���� �������ԣ� (ͨ�����ֶ��� Mouse ��� MouseClass �ཨ�� �����)
	List<Mouse> mouses;
	
	
	
	public List<Mouse> getMouses() {
		return mouses;
	}

	public void setMouses(List<Mouse> mouses) {
		this.mouses = mouses;
	}

	public MouseClass() {
		// TODO Auto-generated constructor stub
	}

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}
	
	@Override
	public String toString() {
		return "ClassId=" + this.classId + "\tclassName=" + this.className 
				+ "\t�༶��Ա��=" + this.mouses;
	}
	

}
