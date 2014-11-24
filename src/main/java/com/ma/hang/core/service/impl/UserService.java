package com.ma.hang.core.service.impl;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ma.hang.core.dao.IUserDao;
import com.ma.hang.core.dao.common.IOperations;
import com.ma.hang.core.dto.UserDto;
import com.ma.hang.core.entities.User;
import com.ma.hang.core.exception.HangTechnicalException;
import com.ma.hang.core.service.IUserService;
import com.ma.hang.core.service.common.AbstractService;


/**
 * @author yboujallab
 * user service to manage user
 */
@Service
public class UserService extends AbstractService<User> implements IUserService {
    @Autowired
    private IUserDao dao;

    /**
     * contructor of user service
     */
    public UserService() {
        super();
    }

    public void createUser(UserDto userDto) throws HangTechnicalException{
        try {
			dao.createUser(userDto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new HangTechnicalException("Erro while saving user",e);
		}
    }
    // API
    @Override
    protected IOperations<User> getDao() {
        return dao;
    }
	@Override
	public User findByEmail(String email) {
		// TODO Auto-generated method stub
		return dao.findByEmail(email);
	}
	@Override
	public boolean authenticate(String email, String submittedPassword)
			throws HangTechnicalException,NoSuchAlgorithmException, InvalidKeySpecException {
		// TODO Auto-generated method stub
		return dao.authenticate(email, submittedPassword);
	}
}
