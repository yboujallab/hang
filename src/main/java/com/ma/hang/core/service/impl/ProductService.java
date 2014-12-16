package com.ma.hang.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ma.hang.core.dao.IProductDao;
import com.ma.hang.core.dao.common.IOperations;
import com.ma.hang.core.entities.Product;
import com.ma.hang.core.entities.User;
import com.ma.hang.core.service.IProductService;
import com.ma.hang.core.service.common.AbstractService;


/**
 * @author yboujallab
 * store service to manage stores
 */
@Service
public class ProductService extends AbstractService<Product> implements IProductService {

    @Autowired
    private IProductDao dao;
	
    /**
     *  Constructor
     */
	public ProductService() {
		super();
	}

	@Override
	protected IOperations<Product> getDao() {
		return dao;
	}

	@Override
	public List<Product> findAllByUser(User user) {
		return ((IProductDao) getDao()).findAllByUser(user);
	}

}
