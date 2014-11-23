package com.ma.hang.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ma.hang.core.dao.IUserDao;
import com.ma.hang.core.dao.common.IOperations;
import com.ma.hang.core.dto.UserDto;
import com.ma.hang.core.entities.User;
import com.ma.hang.core.service.IUserService;
import com.ma.hang.core.service.common.AbstractService;


@Service
public class UserService extends AbstractService<User> implements IUserService {

    @Autowired
    private IUserDao dao;

    public UserService() {
        super();
    }

    public void createUser(UserDto userDto) throws Exception{
        try {
			dao.createUser(userDto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new Exception("Erro while saving user");
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
			throws Exception {
		// TODO Auto-generated method stub
		return dao.authenticate(email, submittedPassword);
	}

    
    
    
}
