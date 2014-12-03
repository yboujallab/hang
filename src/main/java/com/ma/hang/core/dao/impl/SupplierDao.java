package com.ma.hang.core.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ma.hang.core.dao.ISupplierDao;
import com.ma.hang.core.dao.common.AbstractDao;
import com.ma.hang.core.dto.SupplierDto;
import com.ma.hang.core.entities.Supplier;


/**
 * Profil DAO 
 * **/

@Repository
public class SupplierDao extends AbstractDao<Supplier> implements
		ISupplierDao {

	/**
	 * Constructor
	 */
	public SupplierDao() {
		super();
		setClazz(Supplier.class);
	}

	@Override
	public List<Supplier> findByCriteria(SupplierDto supplierBean) {
		//not yet implemented
		return null;
	}

}
