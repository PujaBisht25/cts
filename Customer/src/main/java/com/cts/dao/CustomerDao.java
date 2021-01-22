package com.cts.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.model.Customer;

public interface CustomerDao extends JpaRepository<Customer,Integer> {
      Customer findByName(String name);
}
