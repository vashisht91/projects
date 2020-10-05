package com.piy.biddingservice.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.piy.biddingservice.model.Auction;

public interface AuctionRepository extends CrudRepository<Auction, String> {
	
	public List<Auction> findByStatus(String status);
	
	public Auction findByItemCode(String itemCode);
	
	public Auction findByItemCodeAndStatus(String itemCode, String status);
}
