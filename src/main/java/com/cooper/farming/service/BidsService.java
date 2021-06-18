package com.cooper.farming.service;

import org.springframework.stereotype.Service;

import com.cooper.farming.exception.FarmingServiceException;
import com.cooper.farming.vo.BidVO;
import com.cooper.farming.vo.BidsVO;

@Service
public interface BidsService {

	public BidsVO findBidsByProductId(int productId);
	
	public BidsVO saveOrUpdateBid(BidVO bidVO) throws FarmingServiceException;
	
	public BidsVO getBidsByUserId(int userId) throws FarmingServiceException;
	
}
