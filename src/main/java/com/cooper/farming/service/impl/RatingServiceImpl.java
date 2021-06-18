package com.cooper.farming.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cooper.farming.dto.RatingDTO;
import com.cooper.farming.repository.RatingRepository;
import com.cooper.farming.service.RatingService;
import com.cooper.farming.vo.RatingVO;
import com.cooper.farming.vo.RatingsVO;

@Service
public class RatingServiceImpl implements RatingService {
	
	@Autowired
	private RatingRepository ratingRepository;

	@Override
	public RatingsVO getRatings(int userId) {
		List<RatingDTO> ratingDTOs = ratingRepository.findByUserDTOUserId(userId);
		RatingsVO ratingsVO = new RatingsVO();
		List<RatingVO> ratingVOs = new ArrayList<>();
		if(ratingDTOs != null && !ratingDTOs.isEmpty()) {
			ratingDTOs.forEach(ratingDTO -> ratingVOs.add(getRatingVOByDTO(ratingDTO)));
		}
		ratingsVO.setRatingVOs(ratingVOs);
		return ratingsVO;
	}
	
	/**Method to get rating VO by DTO*/
	public RatingVO getRatingVOByDTO(RatingDTO ratingDTO) {
		RatingVO ratingVO = new RatingVO();
		ratingVO.setOnTimeDelivery(ratingDTO.getOnTimeDelivery());
		ratingVO.setOverallRating(ratingDTO.getOverallRating());
		ratingVO.setPaymentHistory(ratingDTO.getPaymentHistory());
		ratingVO.setProductQuality(ratingDTO.getProductQuality());
		ratingVO.setRatingId(ratingDTO.getRatingId());
		return ratingVO; 
	}

}
