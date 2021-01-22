package com.cts.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cts.dao.CustomerDao;
import com.cts.model.Customer;


@SpringBootTest
public class CustomerServiceTest {
	@Mock
	private CustomerDao dao;
	
	@InjectMocks
	private CustomerServiceImpl service;
	
	@Test
	public void getDetailsTest() {
		when(dao.findAll()).thenReturn(Stream
				.of(new Customer(3, "Danile","male",null), new Customer(9, "machile","male",null)).collect(Collectors.toList()));
		assertEquals(2, service.getDetails().size());
	}
 
   @Test
   public void getProductByIdTest() {
	  Optional<Customer> cus= Optional.of(new Customer(376, "Danile","male",null));
	  int id=376; 
	  when(dao.findById(id)).thenReturn(cus);
	  assertEquals(cus.orElse(null), service.getById(id));
	
	  
	   
   }
  
@Test
   public void getProductByNameTest() {
	Customer cus= new Customer(376, "Danile","male",null);
	  String name="Danile"; 
	  when(dao.findByName(name)).thenReturn(cus);
	  assertEquals(cus, service.getByName(name));
   
   }
	@Test
	public void saveProductTest() {
		Customer cus= new Customer(376, "Danile","male",null);
		when(dao.save(cus)).thenReturn(cus);
		assertEquals(cus, service.addDetail(cus));
	}

	

	@Test
	public void deleteProductTest() {
		Customer cus = new Customer(376, "Danile","male",null);
		service.deleteDetail(cus.getId());
		verify(dao, times(1)).deleteById(cus.getId());
	}
}
