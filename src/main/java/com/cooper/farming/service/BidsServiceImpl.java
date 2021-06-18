package com.cooper.farming.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cooper.farming.constants.BidStatus;
import com.cooper.farming.dto.BidsDTO;
import com.cooper.farming.dto.ProductDTO;
import com.cooper.farming.dto.UserDTO;
import com.cooper.farming.exception.FarmingServiceException;
import com.cooper.farming.repository.BidsRepository;
import com.cooper.farming.vo.BidVO;
import com.cooper.farming.vo.BidsVO;

@Service
public class BidsServiceImpl implements BidsService {
	
	@Autowired
	private BidsRepository bidsRepository;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private UserService userService;
	
	@Override
	public BidsVO findBidsByProductId(int productId) {
		List<BidsDTO> bidsDTOs = bidsRepository.findByProductDTOProductIdOrderByAmountDesc(productId);
		BidsVO bidsVO = new BidsVO();
		List<BidVO> bidVOs = new ArrayList<>();
		if(bidsDTOs != null && !bidsDTOs.isEmpty()) {
			bidsDTOs.forEach(bidDTO -> bidVOs.add(getBidVOByDTO(bidDTO)));
		}
		bidsVO.setBidVOs(bidVOs);
		return bidsVO;
	}

	/**Method to get VO by DTO*/
	public BidVO getBidVOByDTO(BidsDTO bidsDTO) {
		BidVO bidVO = new BidVO();
		bidVO.setAmount(bidsDTO.getAmount());
		bidVO.setFirstName(bidsDTO.getUserDTO().getFirstName());
		bidVO.setLastName(bidsDTO.getUserDTO().getLastName());
		bidVO.setUsername(bidsDTO.getUserDTO().getUserName());
		bidVO.setAddress(bidsDTO.getUserDTO().getAddress());
		bidVO.setCity(bidsDTO.getUserDTO().getCity());
		bidVO.setEmailId(bidsDTO.getUserDTO().getEmailId());
		bidVO.setPhoneNumber(bidsDTO.getUserDTO().getFirstName());
		bidVO.setZipCode(bidsDTO.getUserDTO().getZipCode());
		bidVO.setBidId(bidsDTO.getBidId());
		bidVO.setProductId(bidsDTO.getProductDTO().getProductId());
		bidVO.setUserId(bidsDTO.getUserDTO().getUserId());
		bidVO.setStatus(bidsDTO.getStatus());
		return bidVO;
	}

	@Override
	public BidsVO saveOrUpdateBid(BidVO bidVO) throws FarmingServiceException {
		BidsDTO bidsDTO = getBidDTOByVO(bidVO);
		bidsDTO = bidsRepository.save(bidsDTO);
		bidVO = getBidVOByDTO(bidsDTO);
		if(BidStatus.ACCEPTED.getStatus().equals(bidVO.getStatus())) {
			List<BidsDTO> bidsDTOs = bidsRepository.findByProductDTOProductIdAndBidIdNot(bidVO.getProductId(), bidVO.getBidId());
			bidsDTOs.forEach(bidDTO -> {
				bidDTO.setStatus(BidStatus.REJECTED.getStatus());
			});
			bidsRepository.saveAll(bidsDTOs);
			return findBidsByProductId(bidVO.getProductId());
		} else {
			BidsVO bidsVO = new BidsVO();
			List<BidVO> bidsVOs = new ArrayList<>();
			bidsVOs.add(bidVO);
			bidsVO.setBidVOs(bidsVOs);
			return bidsVO;
		}
		
	}

	/**Method to get bid DTO by VO*/
	private BidsDTO getBidDTOByVO(BidVO bidVO) throws FarmingServiceException {
		BidsDTO bidsDTO = new BidsDTO();
		bidsDTO.setAmount(bidVO.getAmount());
		if(bidVO.getBidId() > 0) {
			bidsDTO.setBidId(bidVO.getBidId());
			bidsDTO.setStatus(bidVO.getStatus());
		} else {
			bidsDTO.setStatus(BidStatus.PENDING.getStatus());
		}
		ProductDTO productDTO = productService.getProductById(bidVO.getProductId());
		bidsDTO.setProductDTO(productDTO);
		UserDTO userDTO = userService.getUserById(bidVO.getUserId());
		bidsDTO.setUserDTO(userDTO);
		
		return bidsDTO;
	}

	@Override
	public BidsVO getBidsByUserId(int userId) throws FarmingServiceException {
		List<BidsDTO> bidsDTOs = bidsRepository.findByUserDTOUserId(userId);
		BidsVO bidsVO = new BidsVO();
		List<BidVO> bidsVOs = new ArrayList<>();
		if(bidsDTOs != null && !bidsDTOs.isEmpty()) {
			bidsDTOs.forEach(bidDTO -> bidsVOs.add(getBidVOByDTO(bidDTO)));
		}
		bidsVO.setBidVOs(bidsVOs);
		return bidsVO;
	}
}
