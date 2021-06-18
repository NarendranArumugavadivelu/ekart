package com.cooper.farming.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cooper.farming.dto.ProductDTO;

@Repository
public interface ProductRepository extends CrudRepository<ProductDTO, Integer> {

	public List<ProductDTO> findByUserDTOUserId(int userId); 
	
	public List<ProductDTO> findByUserDTOCity(String city);
}

