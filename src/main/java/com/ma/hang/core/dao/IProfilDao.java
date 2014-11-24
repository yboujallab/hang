package com.ma.hang.core.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ma.hang.core.dao.common.IOperations;
import com.ma.hang.core.dto.ProfilDto;
import com.ma.hang.core.entities.Profil;


/**
 * @author yboujallab
 * Interface profil DAO
 */
@Repository
public interface IProfilDao extends IOperations<Profil> {
    //
	/**
	 * @param profilBean
	 * @return of profils
	 */
	List<Profil> findByCriteria(ProfilDto profilBean);
}
