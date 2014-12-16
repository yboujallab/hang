package com.ma.hang.core.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ma.hang.core.dao.common.IOperations;
import com.ma.hang.core.entities.Product;
import com.ma.hang.core.entities.User;


/**
 * @author yboujallab
 * Interface profil DAO
 */
@Repository
public interface IProductDao extends IOperations<Product> {
	/**
	 * @param user
	 * @return list of user stores
	 */
	List<Product> findAllByUser(User user);
}
