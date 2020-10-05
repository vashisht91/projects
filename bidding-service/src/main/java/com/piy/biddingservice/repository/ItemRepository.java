package com.piy.biddingservice.repository;

import org.springframework.data.repository.CrudRepository;
import com.piy.biddingservice.model.Auction;
import com.piy.biddingservice.model.Item;

public interface ItemRepository extends CrudRepository<Item, String> {

}
