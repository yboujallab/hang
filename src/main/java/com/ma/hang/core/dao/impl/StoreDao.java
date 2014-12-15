package com.ma.hang.core.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
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
import com.ma.hang.core.entities.User;

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

//	@SuppressWarnings("unchecked")
//	@Override
//	public List<Store> findByCriteria(StoreDto storeDto) {
//		boolean isFirst = true;
//		StringBuilder query = new StringBuilder("from Store ");
//
//		if (storeDto.getCity() != null && !storeDto.getCity().isEmpty()){
//			if (isFirst) {
//				query.append(" where city like '%"
//						+ storeDto.getCity() + "%'");
//			} else {
//				query.append(" and city like '%"
//						+ storeDto.getCity() + "%'");
//			}
//			isFirst = false;
//		}
//
//		if (storeDto.getCountry() != null && !storeDto.getCountry().isEmpty()){
//			if (isFirst) {
//				query.append(" where country like '%"
//						+ storeDto.getCountry() + "%'");
//			} else {
//				query.append(" and country like '%"
//						+ storeDto.getCountry() + "%'");
//			}
//			isFirst = false;
//		}
//		
//		if (storeDto.getPostCode() != null){
//			if (isFirst) {
//				query.append(" where postCode like '%"
//						+ storeDto.getPostCode() + "%'");
//			} else {
//				query.append(" and postCode like '%"
//						+ storeDto.getPostCode() + "%'");
//			}
//			isFirst = false;
//		}		
//		
//		if (storeDto.getStoreAddressFirstLine() != null && !storeDto.getStoreAddressFirstLine().isEmpty()){
//			if (isFirst) {
//				query.append(" where storeAddressFirstLine like '%"
//						+ storeDto.getStoreAddressFirstLine() + "%'");
//			} else {
//				query.append(" and storeAddressFirstLine like '%"
//						+ storeDto.getStoreAddressFirstLine() + "%'");
//			}
//			isFirst = false;
//		}
//
//		if (storeDto.getStoreAddressSecondLine() != null && !storeDto.getStoreAddressSecondLine().isEmpty()){
//			if (isFirst) {
//				query.append(" where storeAddressSecondLine like '%"
//						+ storeDto.getStoreAddressSecondLine() + "%'");
//			} else {
//				query.append(" and storeAddressSecondLine like '%"
//						+ storeDto.getStoreAddressSecondLine() + "%'");
//			}
//			isFirst = false;
//		}
//		if (storeDto.getStoreDescription() != null && !storeDto.getStoreDescription().isEmpty()){
//			if (isFirst) {
//				query.append(" where storeDescription like '%"
//						+ storeDto.getStoreDescription() + "%'");
//			} else {
//				query.append(" and storeDescription like '%"
//						+ storeDto.getStoreDescription() + "%'");
//			}
//			isFirst = false;
//		}	
//		if (storeDto.getStoreName() != null && !storeDto.getStoreName().isEmpty()){
//			if (isFirst) {
//				query.append(" where storeName like '%"
//						+ storeDto.getStoreName() + "%'");
//			} else {
//				query.append(" and storeName like '%"
//						+ storeDto.getStoreName() + "%'");
//			}
//			isFirst = false;
//		}	
//		if (storeDto.getSurface() != null){
//			if (isFirst) {
//				query.append(" where CAST(surface AS DECIMAL) = CAST("
//						+ Float.valueOf(storeDto.getSurface())+" AS DECIMAL)");
//			} else {
//				query.append(" where CAST(surface AS DECIMAL) = CAST("
//						+ Float.valueOf(storeDto.getSurface())+" AS DECIMAL)");
//			}
//			isFirst = false;
//		}	
//		if (storeDto.getCreatedAt() != null){
//			if (isFirst) {
//				query.append(" where createdAt like '%"
//						+ storeDto.getCreatedAt() + "%'");
//			} else {
//				query.append(" and createdAt like '%"
//						+ storeDto.getCreatedAt() + "%'");
//			}
//			isFirst = false;
//		}
//		if (storeDto.getModifiedAt() != null){
//			if (isFirst) {
//				query.append(" where modifiedAt like '%"
//						+ storeDto.getModifiedAt() + "%'");
//			} else {
//				query.append(" and modifiedAt like '%"
//						+ storeDto.getModifiedAt() + "%'");
//			}
//			isFirst = false;
//		}
//		
//		if (storeDto.getUser() != null){
//			if (isFirst) {
//				query.append(" where user.idUser = "
//						+ storeDto.getUser().getIdUser() );
//			} else {
//				query.append(" and user.idUser = "
//						+ storeDto.getUser().getIdUser() );
//			}
//			isFirst = false;
//		}
//		Query result = getCurrentSession().createQuery(query.toString());
//		return result.list();
//	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Store> findByCriteria(StoreDto storeDto) {
		Criteria cr = getCurrentSession().createCriteria(Store.class);

		if (storeDto.getCity() != null && !storeDto.getCity().isEmpty()){
			cr.add(Restrictions.like("city", storeDto.getCity(),MatchMode.ANYWHERE));
		}

		if (storeDto.getCountry() != null && !storeDto.getCountry().isEmpty()){
			cr.add(Restrictions.like("country", storeDto.getCountry(),MatchMode.ANYWHERE));
		}
		
		if (storeDto.getPostCode() != null){
			cr.add(Restrictions.like("postCode", storeDto.getPostCode()));
		}		
		
		if (storeDto.getStoreAddressFirstLine() != null && !storeDto.getStoreAddressFirstLine().isEmpty()){
			cr.add(Restrictions.like("storeAddressFirstLine", storeDto.getStoreAddressFirstLine(),MatchMode.ANYWHERE));
		}

		if (storeDto.getStoreAddressSecondLine() != null && !storeDto.getStoreAddressSecondLine().isEmpty()){
			cr.add(Restrictions.like("storeAddressSecondLine", storeDto.getStoreAddressSecondLine(),MatchMode.ANYWHERE));
		}
		if (storeDto.getStoreDescription() != null && !storeDto.getStoreDescription().isEmpty()){
			cr.add(Restrictions.like("storeDescription", storeDto.getStoreDescription(),MatchMode.ANYWHERE));
		}	
		if (storeDto.getStoreName() != null && !storeDto.getStoreName().isEmpty()){
			cr.add(Restrictions.like("storeName", storeDto.getStoreName(),MatchMode.ANYWHERE));
		}	
		if (storeDto.getSurface() != null){
			cr.add(Restrictions.like("surface", storeDto.getSurface()));
		}	
		if (storeDto.getCreatedAt() != null){
			cr.add(Restrictions.eq("createdAt", storeDto.getCreatedAt()));
		}
		if (storeDto.getModifiedAt() != null){
			cr.add(Restrictions.eq("modifiedAt", storeDto.getModifiedAt()));
		}
		if (storeDto.getUser() != null){
			cr.add(Restrictions.eq("user", storeDto.getUser()));
		}
		//Query result = getCurrentSession().createQuery(query.toString());
		return  cr.list();
	}
	

	@SuppressWarnings("unchecked")
	@Override
	public List<Store> findAllByUser(User user) {
		StringBuilder query = new StringBuilder("from Store ");
		if (user != null){
				query.append(" where user.idUser = "
						+ user.getIdUser() );
		}
		Query result = getCurrentSession().createQuery(query.toString());
		return result.list();
	}
	
}
