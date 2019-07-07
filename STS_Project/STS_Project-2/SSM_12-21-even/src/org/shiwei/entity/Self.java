package org.shiwei.entity;

public class Self {
	private int stuId;
	private int boId;
	
	public Self() {
		
	}

	
	public Self(int stuId, int boId) {
		super();
		this.stuId = stuId;
		this.boId = boId;
	}




	public int getStuId() {
		return stuId;
	}

	public void setStuId(int stuId) {
		this.stuId = stuId;
	}

	public int getBoId() {
		return boId;
	}

	public void setBoId(int boId) {
		this.boId = boId;
	}
	@Override
	public String toString() {
		return "Userid:" + this.stuId + "Boid:" + this.boId;
	}
	
	

}
