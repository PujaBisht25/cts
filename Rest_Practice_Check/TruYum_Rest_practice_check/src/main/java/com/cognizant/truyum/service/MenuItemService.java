package com.cognizant.truyum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.truyum.dao.MenuItemDaoCollectionImpl;
import com.cognizant.truyum.model.MenuItem;

@Service
public class MenuItemService {
	@Autowired
	private MenuItemDaoCollectionImpl menuItemDao;

	public List<MenuItem> getMenuItemListCustomer() {
		List<MenuItem> menuItemListCustomer = menuItemDao.getMenuItemListCustomer();
		return menuItemListCustomer;
	}
	
	public MenuItem getMenuItem(long id)
	{
		return menuItemDao.getMenuItem(id);
	}
	
	public void Save(MenuItem menuItem)
	{
		menuItemDao.modifyMenuItem(menuItem);
	}

}
