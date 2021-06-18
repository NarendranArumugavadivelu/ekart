package com.cooper.farming.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cooper.farming.dto.ItemDTO;

@Repository
public interface ItemRepository extends CrudRepository<ItemDTO, Integer> {

}
