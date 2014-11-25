package com.ma.hang.core.service;

import java.util.List;

import com.ma.hang.core.dao.common.IOperations;
import com.ma.hang.core.dto.StoreDto;
import com.ma.hang.core.entities.Store;



/**
 * @author yboujallab
 * User service interface
 */
public interface IStoreService extends IOperations<Store> {
	
	/**
	 * @param storeBean
	 * @return a list of stores founded
	 */
	List<Store> findByCriteria(StoreDto storeBean);
}
