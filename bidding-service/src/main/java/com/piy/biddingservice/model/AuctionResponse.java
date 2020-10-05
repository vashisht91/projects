package com.piy.biddingservice.model;

public class AuctionResponse {
	private String itemCode;
	private int highestBid;
	private int stepRate;
	private int minBasePrice;
	
	public AuctionResponse() {
	}

	public AuctionResponse(Auction auction) {
		this.itemCode = auction.getItemCode();
		this.highestBid = auction.getCurrentPrice();
		this.stepRate = auction.getStepRate();
		this.minBasePrice = auction.getMinBasePrice();
	}



	public AuctionResponse(String itemCode, int highestBid, int stepRate, int minBasePrice) {
		super();
		this.itemCode = itemCode;
		this.highestBid = highestBid;
		this.stepRate = stepRate;
		this.minBasePrice = minBasePrice;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public int getHighestBid() {
		return highestBid;
	}

	public void setHighestBid(int highestBid) {
		this.highestBid = highestBid;
	}

	public int getStepRate() {
		return stepRate;
	}

	public void setStepRate(int stepRate) {
		this.stepRate = stepRate;
	}

	public int getMinBasePrice() {
		return minBasePrice;
	}

	public void setMinBasePrice(int minBasePrice) {
		this.minBasePrice = minBasePrice;
	}

}
