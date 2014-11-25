package com.ma.hang.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ma.hang.core.dao.IStoreDao;
import com.ma.hang.core.dao.common.IOperations;
import com.ma.hang.core.dto.StoreDto;
import com.ma.hang.core.entities.Store;
import com.ma.hang.core.service.IStoreService;
import com.ma.hang.core.service.common.AbstractService;


/**
 * @author yboujallab
 * store service to manage stores
 */
@Service
public class StoreService extends AbstractService<Store> implements IStoreService {

    @Autowired
    private IStoreDao dao;
	
    /**
     *  Constructor
     */
	public StoreService() {
		super();
	}

	@Override
	protected IOperations<Store> getDao() {
		return dao;
	}

	@Override
	public List<Store> findByCriteria(StoreDto storeBean) {
		return ((IStoreDao) getDao()).findByCriteria(storeBean);
	}

}
