package com.ma.hang.core.service;

import java.util.List;

import com.ma.hang.core.dao.common.IOperations;
import com.ma.hang.core.dto.ProfilDto;
import com.ma.hang.core.entities.Profil;



public interface IProfilService extends IOperations<Profil> {
    //
	List<Profil> findByCriteria(ProfilDto profilBean);
}
