package com.cognizant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cognizant.Repository.UserRepository;
import com.cognizant.entity.CustomUserDetails;
import com.cognizant.entity.User;


@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user=repo.findByUserName(username);
		return new CustomUserDetails(user);
	}

}
