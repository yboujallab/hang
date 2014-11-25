package com.ma.hang.core.dao.impl;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ch.qos.logback.classic.Logger;

import com.ma.hang.core.dao.IProfilDao;
import com.ma.hang.core.dao.IStoreDao;
import com.ma.hang.core.dao.common.AbstractDao;
import com.ma.hang.core.dto.StoreDto;
import com.ma.hang.core.entities.Store;

/**
 * Profil DAO
 * **/

@Repository
@Transactional
public class StoreDao extends AbstractDao<Store> implements IStoreDao {
	final static Logger logger = (Logger) LoggerFactory
			.getLogger(StoreDao.class);

	@Autowired
	private IProfilDao profilDao;

	/**
	 * Constructor
	 */
	public StoreDao() {
		super();
		setClazz(Store.class);
	}

	@Override
	public List<Store> findByCriteria(StoreDto storeDto) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
