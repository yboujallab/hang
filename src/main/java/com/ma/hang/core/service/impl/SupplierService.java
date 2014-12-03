package com.ma.hang.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ma.hang.core.dao.ISupplierDao;
import com.ma.hang.core.dao.common.IOperations;
import com.ma.hang.core.dto.SupplierDto;
import com.ma.hang.core.entities.Supplier;
import com.ma.hang.core.service.ISupplierService;
import com.ma.hang.core.service.common.AbstractService;


/**
 * @author yboujallab
 *
 * Service to manage profil
 */
@Service
public class SupplierService extends AbstractService<Supplier> implements ISupplierService {

    @Autowired
    private ISupplierDao dao;

    /**
     *  Constructor
     */
    public SupplierService() {
        super();
    }

    // API

    @Override
    protected IOperations<Supplier> getDao() {
        return dao;
    }

	@Override
	public List<Supplier> findByCriteria(SupplierDto supplierBean) {
		// TODO Auto-generated method stub
		return ((ISupplierDao) getDao()).findByCriteria(supplierBean);
	}


}
