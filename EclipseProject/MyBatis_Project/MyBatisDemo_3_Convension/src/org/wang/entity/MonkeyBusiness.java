package org.wang.entity;

//���� ҵ�� ��չ��
public class MonkeyBusiness extends Monkey {

	private int cardId;
	private String cardInfo;

	public MonkeyBusiness() {
		// TODO Auto-generated constructor stub
	}

	public int getCardId() {
		return cardId;
	}

	public void setCardId(int cardId) {
		this.cardId = cardId;
	}

	public String getCardInfo() {
		return cardInfo;
	}

	public void setCardInfo(String cardInfo) {
		this.cardInfo = cardInfo;
	}
	
	@Override
	public String toString() {
		return  "stuNo =" + this.getStuNo() + "\tName=" + this.getStuName() + "\tCardId= " 
	       + this.getCardId() + "\tInfo=" + this.getCardInfo();
	}
	

}
