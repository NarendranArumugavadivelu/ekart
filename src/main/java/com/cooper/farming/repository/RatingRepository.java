package com.cooper.farming.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cooper.farming.dto.RatingDTO;

@Repository
public interface RatingRepository extends CrudRepository<RatingDTO, Integer> {

	public List<RatingDTO> findByUserDTOUserId(int userId);
}
