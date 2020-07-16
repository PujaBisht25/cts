package com.cognizant.truyum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.service.MenuItemService;

@RestController
@RequestMapping("/menu-items")
public class MenuItemController 
{
	@Autowired
	private MenuItemService menuItemService;
	
	
	
	@GetMapping()
	public List<MenuItem> getAllMenuItems()
	{
		List<MenuItem> menuItemListCustomer = menuItemService.getMenuItemListCustomer();
		return  menuItemListCustomer;
	}
	
	@GetMapping("/{id}")
	public MenuItem getMenuItem(@PathVariable long id)
	{
		return menuItemService.getMenuItem(id);
	}
	
	@PutMapping()
	public void Save(@RequestBody MenuItem menuItem)
	{
		menuItemService.Save(menuItem);
	}

}
