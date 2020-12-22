package com.ekart.application.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ekart.application.dto.OrderDTO;

@Repository
public interface OrderRepository extends CrudRepository<OrderDTO, Integer> {

}
