package com.cooper.farming.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cooper.farming.dto.BidsDTO;

@Repository
public interface BidsRepository extends CrudRepository<BidsDTO, Integer> {

	public List<BidsDTO> findByProductDTOProductIdOrderByAmountDesc(int productId);
	
	public List<BidsDTO> findByProductDTOProductIdAndBidIdNot(int productId, int bidId);
	
	public List<BidsDTO> findByUserDTOUserId(int userId);
}
