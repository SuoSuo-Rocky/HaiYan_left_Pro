package org.wang.entity;

import java.io.Serializable;

// ʵ���� ���л��� ʵ���� һ���ӿ� ��
public class Monkey  implements Serializable{
	private int stuNo;
    private String stuName;
    private int cardId;
    
    //��ϵ ��һ�ű�  (�൱�� ���ݿ��е� ��� )
    private MonkeyCard card;
    

    
    public MonkeyCard getBusiness() {
		return card;
	}


	public void setBusiness(MonkeyCard business) {
		this.card = business;
	}


	public Monkey() {
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


	public int getCardId() {
		return cardId;
	}


	public void setCardId(int cardId) {
		this.cardId = cardId;
	}
    
    
	@Override
	public String toString() {
		return  "stuId =" + this.stuNo + "\tName=" + this.stuName + "\tCardId= " + 
	this.card.getCardId() + "\tInfo= " + this.card.getCardInfo();
	}
	
	

}