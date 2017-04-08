package com.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import Server.DB.DAO.ConnDB;



public class MyUserDetailService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Collection<GrantedAuthority>auths=new ArrayList<GrantedAuthority>();
		GrantedAuthorityImpl auth2=new GrantedAuthorityImpl("ROLE_USER");
		GrantedAuthorityImpl auth3=new GrantedAuthorityImpl("ROLE_CUSTOMER");
		ConnDB con=new ConnDB();
		List<Server.DB.Bean.User>list=con.executeUser("select * from user where id="+username);
		if(list.size()!=0){
			auths.add(auth2);
			User user = new User(username, list.get(0).getPwd(), true, true, true, true, auths );  
			return user;
			}
		else{
			auths.add(auth3);
			User user = new User(username, "", true, true, true, true,auths);
			return user;
		}
	}

}
