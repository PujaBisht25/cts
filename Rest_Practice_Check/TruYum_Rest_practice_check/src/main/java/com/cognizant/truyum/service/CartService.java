package com.cognizant.truyum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.truyum.dao.CartDaoCollectionImpl;
import com.cognizant.truyum.exception.CartEmptyException;
import com.cognizant.truyum.model.MenuItem;

@Service
public class CartService {
	@Autowired
	private CartDaoCollectionImpl cartdao;

	public void addCartItem(String userid, long menuItemId) {
		cartdao.addCartItem(userid, menuItemId);
	}

	public List<MenuItem> getAllCartItems(String userid) throws CartEmptyException {
		List<MenuItem> allCartItems = cartdao.getAllCartItems(userid);
		return allCartItems;
	}
	
	public void deleteCartItem(String userid, long menuItemId)
	{
		cartdao.removeCartItem(userid, menuItemId);
	}
	
}
