package com.ekart.application.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ekart.application.dto.OrderLineDTO;

@Repository
public interface OrderLineRepository extends CrudRepository<OrderLineDTO, Integer> {

}
