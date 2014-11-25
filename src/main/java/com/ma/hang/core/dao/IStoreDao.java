package com.ma.hang.core.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ma.hang.core.dao.common.IOperations;
import com.ma.hang.core.dto.StoreDto;
import com.ma.hang.core.entities.Store;


/**
 * @author yboujallab
 * Interface profil DAO
 */
@Repository
public interface IStoreDao extends IOperations<Store> {
    //
	/**
	 * @param storeDto
	 * @return list of stores
	 */
	List<Store> findByCriteria(StoreDto storeDto);
}
