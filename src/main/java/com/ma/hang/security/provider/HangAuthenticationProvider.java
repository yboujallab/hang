package com.ma.hang.security.provider;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.ma.hang.core.service.IUserService;

@Component
public class HangAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private IUserService userService;
	
	  public HangAuthenticationProvider() {
	        super();
	    }

	    // API

	    @Override
	    public Authentication authenticate(final Authentication authentication) throws AuthenticationException {
	        final String email = authentication.getName();
	        final String submittedPassword = authentication.getCredentials().toString();
	        boolean isLoginOk=false;
			try {
				isLoginOk = userService.authenticate(email, submittedPassword);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        if (isLoginOk) {
	            final List<GrantedAuthority> grantedAuths = new ArrayList<>();
	            grantedAuths.add(new SimpleGrantedAuthority("ROLE_USER"));
	            final UserDetails principal = new User(email, submittedPassword, grantedAuths);
	            final Authentication auth = new UsernamePasswordAuthenticationToken(principal, submittedPassword, grantedAuths);
	            return auth;
	        } else {
	            return null;
	        }
	    }

	    @Override
	    public boolean supports(final Class<?> authentication) {
	        return authentication.equals(UsernamePasswordAuthenticationToken.class);
	    }

}