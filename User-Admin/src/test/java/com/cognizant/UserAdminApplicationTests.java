package com.cognizant;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cognizant.Repository.ProductRepository;
import com.cognizant.entity.Product;
import com.cognizant.service.ProductService;

@SpringBootTest
class UserAdminApplicationTests {

	@Autowired
	private ProductService service;

	@MockBean
	private ProductRepository repository;

	@Test
	public void getProductsTest() {
		when(repository.findAll()).thenReturn(Stream
				.of(new Product(376, "Danile", 31,8997), new Product(958, "Huy", 35,8980)).collect(Collectors.toList()));
		assertEquals(2, service.getProducts().size());
	}
 
 /*  @Test
   public void getProductByIdTest() {
	  Product product= new Product(376,"Danile",31,8997);
	  int id=376; 
	  when(repository.findById(id).orElse(null)).thenReturn(product);
	  assertEquals(product, service.getProductById(id));
	
	  
	   
   }*/
  
@Test
   public void getProductByNameTest() {
	  Product product= new Product(376,"Danile",31,8997);
	  String name="Danile"; 
	  when(repository.findByName(name)).thenReturn(product);
	  assertEquals(product, service.getProductByName(name));
   
   }
	@Test
	public void saveProductTest() {
		Product product= new Product(99,"Pranya",87, 9080);
		when(repository.save(product)).thenReturn(product);
		assertEquals(product, service.saveProduct(product));
	}

	

	@Test
	public void deleteProductTest() {
		Product product = new Product(999, "Pranya", 33, 87878);
		service.deleteProduct(product.getId());
		verify(repository, times(1)).deleteById(product.getId());
	}
 
}
