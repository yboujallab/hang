package com.ma.hang.core.service;

import com.ma.hang.core.dao.common.IOperations;
import com.ma.hang.core.dto.UserDto;
import com.ma.hang.core.entities.User;



public interface IUserService extends IOperations<User> {
	User findByEmail(String email);
	public boolean authenticate(String email, String submittedPassword) throws Exception;
	public void createUser(UserDto userDto) throws Exception ;
	
}
