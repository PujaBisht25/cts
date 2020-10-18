package com.cognizant.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUserDetails implements UserDetails {
     
	@Autowired
	private User user;

	public CustomUserDetails(User user) {
		this.user=user;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		/*return Arrays.stream(user.getRoles().split(",")).
		map(SimpleGrantedAuthority::new).collect(Collectors.toList());*/
		
		String[] arr=user.getRoles().split(",");
		List<GrantedAuthority> roles=new ArrayList<GrantedAuthority>();
		for (String role : arr) {
			roles.add(new SimpleGrantedAuthority(role));
		}
		
		return roles;
		
			

		
		
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getUserName();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return user.isActive();
	}

}
