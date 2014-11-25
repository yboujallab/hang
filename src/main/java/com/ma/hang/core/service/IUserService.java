package com.ma.hang.core.service;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import com.ma.hang.core.dao.common.IOperations;
import com.ma.hang.core.dto.UserDto;
import com.ma.hang.core.entities.User;
import com.ma.hang.core.exception.HangTechnicalException;



/**
 * @author yboujallab
 * User service interface
 */
public interface IUserService extends IOperations<User> {
	/**
	 * @param email
	 * @return user found by email
	 */
	User findByEmail(String email);
	/**
	 * @param email
	 * @param submittedPassword
	 * @return true if the authentiction is ok and false if not
	 * @throws HangTechnicalException
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeySpecException
	 */
	public User authenticate(String email, String submittedPassword) throws HangTechnicalException,NoSuchAlgorithmException, InvalidKeySpecException;
	/**
	 * @param userDto
	 * @throws HangTechnicalException
	 */
	public void createUser(UserDto userDto) throws HangTechnicalException ;
	
}
