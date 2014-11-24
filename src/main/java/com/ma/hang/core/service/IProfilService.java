package com.ma.hang.core.service;

import java.util.List;

import com.ma.hang.core.dao.common.IOperations;
import com.ma.hang.core.dto.ProfilDto;
import com.ma.hang.core.entities.Profil;



/**
 * @author yboujallab
 * Interafce of profil service
 */
public interface IProfilService extends IOperations<Profil> {
    //
	/**
	 * @param profilBean
	 * @return a list of profils founded
	 */
	List<Profil> findByCriteria(ProfilDto profilBean);
}
