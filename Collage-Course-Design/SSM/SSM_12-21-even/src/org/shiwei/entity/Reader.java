package org.shiwei.entity;

public class Reader {
	private  int stuId;
	private String duPart;
	private int duKind;
	
	public Reader() {
		
		
	}

	
	
	
	public Reader(int stuId, String duPart, int duKind) {
		super();
		this.stuId = stuId;
		this.duPart = duPart;
		this.duKind = duKind;
	}




	public int getStuId() {
		return stuId;
	}

	public void setStuId(int stuId) {
		this.stuId = stuId;
	}

	public String getDuPart() {
		return duPart;
	}

	public void setDuPart(String duPart) {
		this.duPart = duPart;
	}

	public int getDuKind() {
		return duKind;
	}

	public void setDuKind(int duKind) {
		this.duKind = duKind;
	}
	
	
	

}
