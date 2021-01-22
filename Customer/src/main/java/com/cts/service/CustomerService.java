package com.cts.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.cts.model.Customer;

@Service
public interface CustomerService {
		
		
	public Customer addDetail(Customer cus);
		
	public List<Customer> addDetails(List<Customer> cus);
		
	  public List<Customer> getDetails();
		  
	  public Customer getById(int id) ;
		  
	  public Customer getByName(String name);
	  
	  public void deleteDetail(int id);
	  public Customer updateDetails(Customer cus);
}
