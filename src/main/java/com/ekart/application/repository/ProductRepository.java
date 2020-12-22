package com.ekart.application.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ekart.application.dto.ProductDTO;

@Repository
public interface ProductRepository extends CrudRepository<ProductDTO, Integer> {

}
