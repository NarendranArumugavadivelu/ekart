package com.cooper.farming.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cooper.farming.dto.UserDTO;

@Repository
public interface UserRepository extends CrudRepository<UserDTO, Integer> {

	public UserDTO findByUserName(String userName);
	
	public List<UserDTO> findByCityAndRoleDTORoleName(String city, String roleName);
	
}
