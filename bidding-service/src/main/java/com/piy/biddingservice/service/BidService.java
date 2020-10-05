package com.piy.biddingservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.piy.biddingservice.model.Auction;
import com.piy.biddingservice.model.UserBid;
import com.piy.biddingservice.repository.AuctionRepository;
import com.piy.biddingservice.repository.BidRepository;

@Service
public class BidService {

	@Autowired
	private BidRepository bidRepository;
	
	@Autowired
	private AuctionRepository auctionRepository;
	
	public List<UserBid> getAllBids() {
		List<UserBid> userBids = new ArrayList<>();
		bidRepository.findAll().forEach(userBids::add);
		return userBids;
	}	
	
	public List<UserBid> getAllBidsForItem(String itemCode) {
		List<UserBid> userBids = new ArrayList<>();
		bidRepository.findAll().forEach(userBids::add);
		return userBids;
	}	
	
	public ResponseEntity<String> placeBid(int bidAmount, String itemCode) {
		UserBid bid = new UserBid();
		bid.setBidAmount(bidAmount);
		ResponseEntity<String> response = null;
		Auction auction = auctionRepository.findByItemCodeAndStatus(itemCode, "Running");
		if(auction != null) {
			bid.setAuction(auction);
			if(bid.getBidAmount() < auction.getMinBasePrice() ) {
				bid.setBidStatus("Rejected");
				response = new ResponseEntity<String>("Bid is rejected", HttpStatus.NOT_ACCEPTABLE);
				System.out.println("Bid Amount less than minBasePrice");
			}
			else if(bid.getBidAmount() < (auction.getCurrentPrice() + auction.getStepRate())) {
				bid.setBidStatus("Rejected");
				response = new ResponseEntity<String>("Bid is rejected", HttpStatus.NOT_ACCEPTABLE);
				System.out.println("Bid Amount less than Step Rate");
			}
			else {
				bid.setBidStatus("Accepted");
				auction.setCurrentPrice(bid.getBidAmount());
				auctionRepository.save(auction);
				response = new ResponseEntity<String>("Bid is accepted", HttpStatus.CREATED);
			}
			bidRepository.save(bid);
			return response;
		}
		bid.setBidStatus("Rejected");
		bidRepository.save(bid);
		response = new ResponseEntity<String>("Auction not found", HttpStatus.NOT_FOUND);
		System.out.println("Auction not found");
		return response;
		
	}
}
