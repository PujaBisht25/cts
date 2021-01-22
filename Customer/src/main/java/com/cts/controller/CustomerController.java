package com.cts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.exception.InvalidIdException;
import com.cts.model.Customer;

import com.cts.service.CustomerServiceImpl;
@RestController
public class CustomerController {
	
	@Autowired
	private CustomerServiceImpl service;
	
	@PostMapping("/add")
	public Customer addCustomer(@RequestBody Customer cus)
	{
		return service.addDetail(cus);
	}
	@PostMapping("/addDetails")
	public List<Customer> addCustomers(@RequestBody List<Customer> cus)
	{
		return service.addDetails(cus);
	}
	
	@GetMapping("/viewAll")
	public List<Customer> findAllProducts(){
		return service.getDetails();
	}
	
	@GetMapping("/view/ById/{id}")
	public Customer findProductById(@PathVariable int id) throws InvalidIdException{
		   Customer cus=service.getById(id);
		   if(cus == null)
			{		
			throw new InvalidIdException("The Id is Inavlid");
			
		}
			else
				 return cus ;
		
	}
    @GetMapping("/view/ByName/{name}")
    public Customer findProductByName(@PathVariable String name) {
    	return service.getByName(name);
    	
    }
    @PutMapping("/update")
    public Customer updateProduct(@RequestBody Customer cus) {
    	return service.updateDetails(cus);
    }
	@DeleteMapping("/delete/{id}")
	public void deleteProduct(@PathVariable int id) {
	       service.deleteDetail(id);;
	}


}
