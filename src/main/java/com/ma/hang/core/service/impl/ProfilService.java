package com.ma.hang.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ma.hang.core.dao.IProfilDao;
import com.ma.hang.core.dao.common.IOperations;
import com.ma.hang.core.dto.ProfilDto;
import com.ma.hang.core.entities.Profil;
import com.ma.hang.core.service.IProfilService;
import com.ma.hang.core.service.common.AbstractService;


@Service
public class ProfilService extends AbstractService<Profil> implements IProfilService {

    @Autowired
    private IProfilDao dao;

    public ProfilService() {
        super();
    }

    // API

    @Override
    protected IOperations<Profil> getDao() {
        return dao;
    }

	@Override
	public List<Profil> findByCriteria(ProfilDto profilBean) {
		// TODO Auto-generated method stub
		return dao.findByCriteria(profilBean);
	}


}
