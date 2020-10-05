package com.piy.biddingservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.piy.biddingservice.model.Auction;
import com.piy.biddingservice.model.AuctionResponse;
import com.piy.biddingservice.repository.AuctionRepository;

@Service
public class AuctionService {
	@Autowired
	private AuctionRepository auctionRepository;
	
	public List<AuctionResponse> getAllAuctions() {
		List<Auction> auctions = new ArrayList<>();
		List<AuctionResponse> auctionResponses = new ArrayList<>();
		auctionRepository.findAll().forEach(auctions::add);
		for(Auction auction : auctions)
			auctionResponses.add(new AuctionResponse(auction));
		
		return auctionResponses;
	}
	
	public List<AuctionResponse> getAllAuctions(String status) {
		List<Auction> auctions = new ArrayList<>();
		List<AuctionResponse> auctionResponses = new ArrayList<>();
		auctionRepository.findByStatus(status).forEach(auctions::add);
		for(Auction auction : auctions)
			auctionResponses.add(new AuctionResponse(auction));
		return auctionResponses;
	}
	
	public Auction getAuctionByItemCode(String itemCode) {
		return auctionRepository.findByItemCode(itemCode);
	}
	
	public void addAuction(Auction auction) {
		auctionRepository.save(auction);
	}
	
	public void addAuctions(List<Auction> auctions) {
		auctionRepository.saveAll(auctions);
	}
	
	public void updateAuction(Auction auction) {
		auctionRepository.save(auction);
	}
	
	public void deleteAuction(String id) {
		auctionRepository.deleteById(id);
	}
}
