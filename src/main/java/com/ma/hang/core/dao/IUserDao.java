package com.ma.hang.core.dao;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import org.springframework.stereotype.Repository;

import com.ma.hang.core.dao.common.IOperations;
import com.ma.hang.core.dto.UserDto;
import com.ma.hang.core.entities.User;
import com.ma.hang.core.exception.HangTechnicalException;


/**
 * @author yboujallab
 * User dao interface
 */
@Repository
public interface IUserDao extends IOperations<User> {
	/**
	 * @param email
	 * @return user
	 */
	User findByEmail(String email);
	/**
	 * @param email
	 * @param submittedPassword
	 * @return boolean s
	 * @throws HangTechnicalException
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeySpecException
	 */
	public boolean authenticate(String email, String submittedPassword) throws HangTechnicalException,NoSuchAlgorithmException, InvalidKeySpecException;
	/**
	 * @param userDto
	 * @throws HangTechnicalException
	 */
	public void createUser(UserDto userDto) throws HangTechnicalException ;
}
