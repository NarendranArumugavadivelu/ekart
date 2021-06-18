package com.cooper.farming.service;

import org.springframework.stereotype.Service;

import com.cooper.farming.vo.RatingsVO;

@Service
public interface RatingService {

	public RatingsVO getRatings(int userId);
}
