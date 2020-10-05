package com.piy.biddingservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.piy.biddingservice.model.Auction;
import com.piy.biddingservice.model.AuctionResponse;
import com.piy.biddingservice.model.UserBid;
import com.piy.biddingservice.service.AuctionService;
import com.piy.biddingservice.service.BidService;

@RestController
public class AuctionController {

	@Autowired
	private AuctionService auctionService;
	
	@Autowired
	private BidService bidService;
	
	@RequestMapping("/auction")
	public List<AuctionResponse> getAuctions(@RequestParam(value="status", required=false) String auctionStatus) {
		if(auctionStatus==null)
			return auctionService.getAllAuctions();
		return auctionService.getAllAuctions(auctionStatus);
	}
	
	
	@RequestMapping(method=RequestMethod.POST, value="/auction")
	public void addAuction(@RequestBody Auction auction) {
		auctionService.addAuction(auction);
	}
	
	
	@RequestMapping(method=RequestMethod.POST, value="/auctions")
	public void addAuctions(@RequestBody List<Auction> auction) {
		auctionService.addAuctions(auction);
	}
	
	@RequestMapping("/bid")
	public void getBids() {
		bidService.getAllBids();
	}
	
	@RequestMapping("/auction/{itemCode}/bid")
	public List<UserBid> getBidsForItem(@PathVariable String itemCode) {
		return bidService.getAllBidsForItem(itemCode);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/auction/{itemCode}/bid")
	public ResponseEntity<String> placeBid(@RequestBody String bidAmount, @PathVariable String itemCode) {
		return bidService.placeBid(Integer.parseInt(bidAmount), itemCode);
	}
	
}
