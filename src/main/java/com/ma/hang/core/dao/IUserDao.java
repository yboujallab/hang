package com.ma.hang.core.dao;

import org.springframework.stereotype.Repository;

import com.ma.hang.core.dao.common.IOperations;
import com.ma.hang.core.entities.User;


@Repository
public interface IUserDao extends IOperations<User> {
	User findByEmail(String email);
	public boolean authenticate(String email, String submittedPassword) throws Exception;
}
