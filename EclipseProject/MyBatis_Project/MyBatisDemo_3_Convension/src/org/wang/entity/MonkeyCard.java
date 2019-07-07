package org.wang.entity;

import java.io.Serializable;

public class MonkeyCard  implements Serializable {
	private int cardId;
	private String cardInfo;
	
	public MonkeyCard() {
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
		return "MonkeyCard_cardId = " + this.cardId + "info= " + this.cardInfo;
	}
	

}
