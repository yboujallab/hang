package com.ma.hang.core.dao.impl;

import java.util.List;

import org.hibernate.Query;
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

	@SuppressWarnings("unchecked")
	@Override
	public List<Supplier> findByCriteria(SupplierDto supplierBean) {
		boolean isFirst = true;
		StringBuilder query = new StringBuilder("from Supplier ");
		
		if(supplierBean.getActivity()!= null && !supplierBean.getActivity().isEmpty()) {
			if (isFirst) {
				query.append(" where activity like '%"
						+ supplierBean.getActivity() + "%'");
			} else {
				query.append(" and activity like '%"
						+ supplierBean.getActivity() + "%'");
			}
			isFirst = false;
		}
		if(supplierBean.getName()!= null && !supplierBean.getName().isEmpty()) {
			if (isFirst) {
				query.append(" where name like '%"
						+ supplierBean.getName() + "%'");
			} else {
				query.append(" and name like '%"
						+ supplierBean.getName() + "%'");
			}
			isFirst = false;
		}	
		if(supplierBean.getAddress()!= null && !supplierBean.getAddress().isEmpty()) {
			if (isFirst) {
				query.append(" where address like '%"
						+ supplierBean.getAddress() + "%'");
			} else {
				query.append(" and address like '%"
						+ supplierBean.getAddress() + "%'");
			}
			isFirst = false;
		}
		if(supplierBean.getCountry()!= null && !supplierBean.getCountry().isEmpty()) {
			if (isFirst) {
				query.append(" where country like '%"
						+ supplierBean.getCountry() + "%'");
			} else {
				query.append(" and country like '%"
						+ supplierBean.getCountry() + "%'");
			}
			isFirst = false;
		}
		if(supplierBean.getCity()!= null && !supplierBean.getCity().isEmpty()) {
			if (isFirst) {
				query.append(" where city like '%"
						+ supplierBean.getCity() + "%'");
			} else {
				query.append(" and city like '%"
						+ supplierBean.getCity() + "%'");
			}
			isFirst = false;
		}
		if(supplierBean.getPostCode()!= null && !supplierBean.getPostCode().isEmpty()) {
			if (isFirst) {
				query.append(" where postCode like '%"
						+ supplierBean.getPostCode() + "%'");
			} else {
				query.append(" and postCode like '%"
						+ supplierBean.getPostCode() + "%'");
			}
			isFirst = false;
		}
		if(supplierBean.getUser()!= null) {
			if (isFirst) {
				query.append(" where postCode like '%"
						+ supplierBean.getPostCode() + "%'");
			} else {
				query.append(" and postCode like '%"
						+ supplierBean.getPostCode() + "%'");
			}
			isFirst = false;
		}		
		Query result = getCurrentSession().createQuery(query.toString());
		return result.list();
	}

}
