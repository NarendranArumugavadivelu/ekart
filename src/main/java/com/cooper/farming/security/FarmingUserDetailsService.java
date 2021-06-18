package com.cooper.farming.security;

import java.util.Arrays;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cooper.farming.dto.UserDTO;
import com.cooper.farming.repository.UserRepository;

@Service
public class FarmingUserDetailsService implements UserDetailsService {
	
	private UserRepository userRepository;

	public FarmingUserDetailsService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String userName) {
		UserDTO userDTO = userRepository.findByUserName(userName);
		if(userDTO == null) {
			throw new UsernameNotFoundException("User not found for: " + userName);
		} else {
			GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(userDTO.getRoleDTO().getRoleName());
			return new User(userDTO.getUserName(), userDTO.getPassword(), Arrays.asList(grantedAuthority));
		}
	}

}
