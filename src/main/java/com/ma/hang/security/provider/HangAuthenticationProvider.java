package com.ma.hang.security.provider;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.ma.hang.core.service.IUserService;

/**
 * @author yboujallab
 * Calss to manage the authentication 
 *
 */
@Component
public class HangAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private IUserService userService;
	
	  /**
	 * 
	 */
	public HangAuthenticationProvider() {
	        super();
	    }

	    // API

	    @Override
	    public Authentication authenticate(final Authentication authentication) throws AuthenticationException {
	        final String email = authentication.getName();
	        final String submittedPassword = authentication.getCredentials().toString();
	        
			if (email.trim().equals("") || email == null) {
				//Error no login typed
				throw new BadCredentialsException("Invalid username" );
			}
	 
			if (submittedPassword.equals("") || submittedPassword == null) {
				//Error no login typed
				throw new BadCredentialsException("Invalid Password" );
			}
			
	        com.ma.hang.core.entities.User user=null;
			try {
				user = userService.authenticate(email.trim(), submittedPassword);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        if (user != null) {
		        final Integer profilId = user.getProfil().getIdProfil();
		        final List<GrantedAuthority> authorithies = new ArrayList<GrantedAuthority>();
		        GrantedAuthority ga =  getAuthority(profilId);
		        authorithies.add(ga);
	            final UserDetails principal = new User(email, submittedPassword, false, false, false, false, authorithies);
	            final Authentication auth = new UsernamePasswordAuthenticationToken(principal, submittedPassword, authorithies);
	            return auth;
	        } else {
	            return null;
	        }
	    }
	    @Override
	    public boolean supports(final Class<?> authentication) {
	        return authentication.equals(UsernamePasswordAuthenticationToken.class);
	    }
	    /**
	     * @param profilId
	     * @return GrantedAuthority
	     */
	    public GrantedAuthority getAuthority(Integer profilId){
	    	
	        final GrantedAuthority auth = new GrantedAuthority() {
				/**
				 * 
				 */

				public String getAuthority() {
					switch (profilId){
						case 1:
							return HangConstants.ADMIN_ROLE;
						
						case 2:
							return HangConstants.USER_ROLE;
						
						default:
							return HangConstants.ERROR;
					}
					
				}        		
			};
			return auth;
	    }
	    
	    
}