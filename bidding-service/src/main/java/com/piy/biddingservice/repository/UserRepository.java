package com.piy.biddingservice.repository;

import org.springframework.data.repository.CrudRepository;
import com.piy.biddingservice.model.Auction;
import com.piy.biddingservice.model.User;

public interface UserRepository extends CrudRepository<User, String> {

	public User findByUserIdAndUserPwd(String userId, String userPwd);
}
