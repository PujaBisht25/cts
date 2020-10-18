package com.cognizant.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


import com.cognizant.entity.Product;
import com.cognizant.service.ProductService;

@RestController

public class ProductController {
	@Autowired
	private ProductService service;
	
	@PostMapping("/admin/add")
	public Product addProduct(@RequestBody Product product)
	{
		return service.saveProduct(product);
	}
	@PostMapping("/admin/addProducts")
	public List<Product> addProducts(@RequestBody List<Product> products)
	{
		return service.saveProducts(products);
	}
	
	@GetMapping("/view/products")
	public List<Product> findAllProducts(){
		return service.getProducts();
	}
	
	@GetMapping("/view/productById/{id}")
	public Product findProductById(@PathVariable int id) {
		return service.getProductById(id);
		
	}
    @GetMapping("/view/productByName/{name}")
    public Product findProductByName(@PathVariable String name) {
    	return service.getProductByName(name);
    	
    }
    @PutMapping("/admin/update")
    public Product updateProduct(@RequestBody Product product) {
    	return service.updateProduct(product);
    }
	@DeleteMapping("/admin/delete/{id}")
	public void deleteProduct(@PathVariable int id) {
	       service.deleteProduct(id);
	}

}
