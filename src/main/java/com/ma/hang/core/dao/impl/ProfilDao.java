package com.ma.hang.core.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.ma.hang.core.dao.IProfilDao;
import com.ma.hang.core.dao.common.AbstractDao;
import com.ma.hang.core.dto.ProfilDto;
import com.ma.hang.core.entities.Profil;


/**
 * Profil DAO 
 * **/

@Repository
public class ProfilDao extends AbstractDao<Profil> implements
		IProfilDao {

	/**
	 * Constructor
	 */
	public ProfilDao() {
		super();
		setClazz(Profil.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Profil> findByCriteria(ProfilDto profilBean) {
		boolean isFirst = true;
		StringBuilder query = new StringBuilder("from Profil ");
		if (profilBean.getProfilDescription() != null) {
			if (isFirst) {
				query.append(" where profil_description like '%"
						+ profilBean.getProfilDescription() + "%'");
			} else {
				query.append(" and profil_description like '%"
						+ profilBean.getProfilDescription() + "%'");
			}
			isFirst = false;
		}
		if (profilBean.getProfilName() != null) {
			if (isFirst) {
				query.append(" where profil_name like '%"
						+ profilBean.getProfilName() + "%'");
			} else {
				query.append(" and profil_name like '%"
						+ profilBean.getProfilName() + "%'");
			}
			isFirst = false;
		}
		Query result = getCurrentSession().createQuery(query.toString());
		return result.list();
	}

}
