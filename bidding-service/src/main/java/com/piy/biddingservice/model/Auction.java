package com.piy.biddingservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Auction {
	@Id
	private String auctionId;
	private String itemCode;
	private int minBasePrice;
	private int stepRate;
	private int currentPrice;
	private String status;
	private String currency = "INR";

	public Auction() {
	}

	public Auction(String auctionId, String itemCode, int minBasePrice, int stepRate, String status, String currency) {
		super();
		this.auctionId = auctionId;
		this.itemCode = itemCode;
		this.minBasePrice = minBasePrice;
		this.stepRate = stepRate;
		this.status = status;
		this.currency = currency;
		this.currentPrice = minBasePrice;
	}

	public String getAuctionId() {
		return auctionId;
	}

	public void setAuctionId(String auctionId) {
		this.auctionId = auctionId;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public int getMinBasePrice() {
		return minBasePrice;
	}

	public void setMinBasePrice(int minBasePrice) {
		this.minBasePrice = minBasePrice;
	}

	public int getStepRate() {
		return stepRate;
	}

	public void setStepRate(int stepRate) {
		this.stepRate = stepRate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public int getCurrentPrice() {
		return currentPrice;
	}

	public void setCurrentPrice(int currentPrice) {
		this.currentPrice = currentPrice;
	}

}
