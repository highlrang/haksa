package com.myproject.myweb.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@SuppressWarnings("serial") //??
public class UserVO implements UserDetails{
	String user_id; // string
	String user_password;
	
	String user_name;
	String user_phone;
	String user_email;
	String user_major;
	String user_minor;
	
	String user_role;
	
	
	public UserVO() {}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities(){
		List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();
		authList.add(new SimpleGrantedAuthority(user_role));
		return authList;
	}
	
	@Override
	public String getUsername() {
		return user_id;
	}
	
	@Override
	public String getPassword() {
		return user_password;
	}
	
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	
	public String getUser_name() {
		return user_name;
	}


	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}


	public String getUser_phone() {
		return user_phone;
	}


	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}


	public String getUser_email() {
		return user_email;
	}


	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}


	public String getUser_major() {
		return user_major;
	}


	public void setUser_major(String user_major) {
		this.user_major = user_major;
	}


	public String getUser_minor() {
		return user_minor;
	}


	public void setUser_minor(String user_minor) {
		this.user_minor = user_minor;
	}


	public String getUser_role() {
		return user_role;
	}


	public void setUser_role(String user_role) {
		this.user_role = user_role;
	};
	
	
	
}
