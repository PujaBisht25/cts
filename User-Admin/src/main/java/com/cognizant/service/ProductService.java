package com.cognizant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.Repository.ProductRepository;
import com.cognizant.entity.Product;


@Service

public class ProductService {
	@Autowired
	private ProductRepository repository;
	
	public Product saveProduct(Product product) {
		return repository.save(product);
	}
	public List<Product> saveProducts(List<Product> products){
		return repository.saveAll(products);
	}
	
	public List<Product> getProducts(){
		List<Product> product = repository.findAll();
		
		return product;
		
	}
	public Product getProductById(int id) {
		
		return repository.findById(id).orElse(null);
	}
	public Product getProductByName(String name) {
		return repository.findByName(name);
	}
	public void deleteProduct(int id) {
	     repository.deleteById(id);
	    
	}
    public Product updateProduct(Product product)
    {
    	Product exist =repository.findById(product.getId()).orElse(null);
    	exist.setName(product.getName());
    	exist.setQuantity(product.getQuantity());
    	exist.setPrice(product.getPrice());
    	return repository.save(exist);
    	
    }
    
}
