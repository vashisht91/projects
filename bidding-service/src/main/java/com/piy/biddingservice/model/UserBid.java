package com.piy.biddingservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class UserBid {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int bidId;
	private String userId;
	private String bidStatus;
	private int bidAmount;
	@ManyToOne
	private Auction auction;

	public UserBid() {
	}

	public UserBid(int bidId, String userId, String bidStatus, int bidAmount, Auction auction) {
		super();
		this.bidId = bidId;
		this.userId = userId;
		this.bidStatus = bidStatus;
		this.bidAmount = bidAmount;
		this.auction = auction;
	}

	public int getBidId() {
		return bidId;
	}

	public void setBidId(int bidId) {
		this.bidId = bidId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getBidStatus() {
		return bidStatus;
	}

	public void setBidStatus(String bidStatus) {
		this.bidStatus = bidStatus;
	}

	public Auction getAuction() {
		return auction;
	}

	public void setAuction(Auction auction) {
		this.auction = auction;
	}

	public int getBidAmount() {
		return bidAmount;
	}

	public void setBidAmount(int bidAmount) {
		this.bidAmount = bidAmount;
	}

}
