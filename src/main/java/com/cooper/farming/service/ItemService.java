package com.cooper.farming.service;

import org.springframework.stereotype.Service;

import com.cooper.farming.dto.ItemDTO;
import com.cooper.farming.exception.FarmingServiceException;
import com.cooper.farming.vo.ItemsVO;

@Service
public interface ItemService {

	public ItemsVO getItems();
	
	public ItemDTO getItemById(Integer itemId) throws FarmingServiceException;
}
