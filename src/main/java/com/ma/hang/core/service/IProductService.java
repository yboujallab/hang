package com.ma.hang.core.service;

import java.util.List;

import com.ma.hang.core.dao.common.IOperations;
import com.ma.hang.core.entities.Product;
import com.ma.hang.core.entities.User;



/**
 * @author yboujallab
 * User service interface
 */
public interface IProductService extends IOperations<Product> {
	
	/**
	 * @param user
	 * @return list of user stores
	 */
	List<Product> findAllByUser(User user);	
}
