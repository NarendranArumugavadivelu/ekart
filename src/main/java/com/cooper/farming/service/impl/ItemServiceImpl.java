package com.cooper.farming.service.impl;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

import org.springframework.stereotype.Service;

import com.cooper.farming.constants.Constants;
import com.cooper.farming.dto.ItemDTO;
import com.cooper.farming.exception.FarmingServiceException;
import com.cooper.farming.repository.ItemRepository;
import com.cooper.farming.service.ItemService;
import com.cooper.farming.vo.ErrorVO;
import com.cooper.farming.vo.ItemVO;
import com.cooper.farming.vo.ItemsVO;

@Service
public class ItemServiceImpl implements ItemService {
	
	private ItemRepository itemRepository;
	
	private Properties errorProperties;
	
	public ItemServiceImpl(ItemRepository itemRepository, Properties errorProperties) {
		this.itemRepository = itemRepository;
		this.errorProperties = errorProperties;
	}

	@Override
	public ItemsVO getItems() {
		ItemsVO itemsVO = new ItemsVO();
		List<ItemVO> itemVOs = new ArrayList<>();
		Iterable<ItemDTO> itemIterable = itemRepository.findAll();
		itemIterable.forEach(itemDTO -> itemVOs.add(getItemVOByDTO(itemDTO)));
		itemsVO.setItemsVOs(itemVOs);
		return itemsVO;
	}
	
	@Override
	public ItemDTO getItemById(Integer itemId) throws FarmingServiceException {
		Optional<ItemDTO> optional = itemRepository.findById(itemId);
		if(optional.isPresent()) {
			return optional.get();
		} else {
			String message = MessageFormat.format(errorProperties.getProperty(Constants.ITEM_DOES_NOT_EXISTS), itemId);
			ErrorVO errorVO = new ErrorVO();
			errorVO.setErrorCode(Constants.ITEM_DOES_NOT_EXISTS);
			errorVO.setErrorMessage(message);
			throw new FarmingServiceException(message, errorVO);
		}
	}
	
	/**Method to get the item VO by DTO*/
	private ItemVO getItemVOByDTO(ItemDTO itemDTO) {
		ItemVO itemVO = new ItemVO();
		itemVO.setId(itemDTO.getItemId());
		itemVO.setName(itemDTO.getItemName());
		itemVO.setCategoryId(itemDTO.getCategoryDTO().getCategoryId());
		itemVO.setCategoryName(itemDTO.getCategoryDTO().getCategoryName());
		return itemVO;
	}

}
