package org.shiwei.entity;

public class Book {
	
	private int  boId;
	private int duKind;
	private String boName;
	private int boRank;
	private String boImg;
	
	public Book() {
		
		
	}
	
	
	
	public Book(int boId, int duKind, String boName, int boRank, String boImg) {
		super();
		this.boId = boId;
		this.duKind = duKind;
		this.boName = boName;
		this.boRank = boRank;
		this.boImg = boImg;
	}
	public int getBoId() {
		return boId;
	}
	public void setBoId(int boId) {
		this.boId = boId;
	}
	public int getDuKind() {
		return duKind;
	}
	public void setDuKind(int duKind) {
		this.duKind = duKind;
	}
	public String getBoName() {
		return boName;
	}
	public void setBoName(String boName) {
		this.boName = boName;
	}
	public int getBoRank() {
		return boRank;
	}
	public void setBoRank(int boRank) {
		this.boRank = boRank;
	}
	public String getBoImg() {
		return boImg;
	}
	public void setBoImg(String boImg) {
		this.boImg = boImg;
	}
	
	
	
	

}
