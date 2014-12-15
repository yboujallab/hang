package com.ma.hang.core.service;

import java.util.List;

import com.ma.hang.core.dao.common.IOperations;
import com.ma.hang.core.dto.SupplierDto;
import com.ma.hang.core.entities.Supplier;
import com.ma.hang.core.entities.User;



/**
 * @author yboujallab
 * Interafce of profil service
 */
public interface ISupplierService extends IOperations<Supplier> {
    //
	/**
	 * @param profilBean
	 * @return a list of profils founded
	 */
	List<Supplier> findByCriteria(SupplierDto profilBean);
	/**
	 * @param user
	 * @return list of user supplier
	 */
	List<Supplier> findAllByUser(User user);

}
