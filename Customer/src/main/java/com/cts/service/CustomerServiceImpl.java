package com.cts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cts.dao.CustomerDao;
import com.cts.model.Customer;
@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerDao dao;
	
	
	@Override
	public Customer addDetail(Customer cus)
	{
		return dao.save(cus);
		
	}
	public List<Customer> addDetails(List<Customer> cus)
	{
		return dao.saveAll(cus);
	}
   public List<Customer> getDetails(){
	  List<Customer> cus = dao.findAll();
	  return cus;
  }
   public Customer getById(int id) {
	  return dao.findById(id).orElse(null);
  }
  public Customer getByName(String name)
  {
	  return dao.findByName(name);
  }
  public void deleteDetail(int id) {
	     dao.deleteById(id);
	    
	}
  public Customer updateDetails(Customer cus)
    {
	  Customer exist =dao.findById(cus.getId()).orElse(null);
    	exist.setName(cus.getName());
    	exist.setGender(cus.getGender());
    	exist.setDob(cus.getDob());
    	return dao.save(exist);
    	
    }


}
