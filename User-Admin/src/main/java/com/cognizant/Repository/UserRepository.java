package com.cognizant.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.entity.User;



public interface UserRepository extends JpaRepository<User, Integer> {

	User findByUserName(String username);
}


