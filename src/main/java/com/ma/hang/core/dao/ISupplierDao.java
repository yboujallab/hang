package com.ma.hang.core.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ma.hang.core.dao.common.IOperations;
import com.ma.hang.core.dto.SupplierDto;
import com.ma.hang.core.entities.Supplier;


/**
 * @author yboujallab
 * Interface supplier DAO
 */
@Repository
public interface ISupplierDao extends IOperations<Supplier> {
    //
	/**
	 * @param supplierBean
	 * @return list of Suppliers
	 */
	List<Supplier> findByCriteria(SupplierDto supplierBean);
}
