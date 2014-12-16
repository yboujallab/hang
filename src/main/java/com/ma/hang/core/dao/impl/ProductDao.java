package com.ma.hang.core.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ch.qos.logback.classic.Logger;

import com.ma.hang.core.dao.IProductDao;
import com.ma.hang.core.dao.common.AbstractDao;
import com.ma.hang.core.entities.Product;
import com.ma.hang.core.entities.User;

/**
 * Profil DAO
 * **/

@Repository
@Transactional
public class ProductDao extends AbstractDao<Product> implements IProductDao {
	final static Logger logger = (Logger) LoggerFactory
			.getLogger(ProductDao.class);

	/**
	 * Constructor
	 */
	public ProductDao() {
		super();
		setClazz(Product.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> findAllByUser(User user) {
		Criteria cr = getCurrentSession().createCriteria(Product.class);
		if (user != null){
				if (user.getSuppliers() != null && user.getSuppliers().size()>0 && !user.getSuppliers().isEmpty() )
						cr.add(Restrictions.in("supplier", user.getSuppliers()));
		}
		return  cr.list();	
		}
	
}
