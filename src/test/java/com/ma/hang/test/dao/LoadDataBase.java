package com.ma.hang.test.dao;

import java.util.Calendar;
import java.util.Date;

import org.hibernate.HibernateException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.ma.hang.core.dao.IProfilDao;
import com.ma.hang.core.dao.IStoreDao;
import com.ma.hang.core.dao.IUserDao;
import com.ma.hang.core.dto.UserDto;
import com.ma.hang.core.entities.Profil;
import com.ma.hang.core.entities.Store;
import com.ma.hang.core.exception.HangTechnicalException;
import com.ma.hang.core.service.IProfilService;
import com.ma.hang.core.service.IStoreService;
import com.ma.hang.core.service.IUserService;

public class LoadDataBase {


public static void main(String[] args) throws HangTechnicalException {
	
	
    ApplicationContext context = new ClassPathXmlApplicationContext("load-data-context.xml");
    IUserService usersrv = (IUserService) context.getBean("userService");
    IProfilService profilsrv = (IProfilService) context.getBean("profilService");
    IStoreService storesrv = (IStoreService) context.getBean("storeService");
    LoadDataBase load = new LoadDataBase();
    //load.insertProfils(profildao);
    //load.createUser(userdao, profildao);
    load.createStoresDaoTest(usersrv, storesrv);
}
	

	public void insertProfils(IProfilService profilSrv ){
		Profil profil = null;
		try {
			//insert profils
				profil = new Profil();
				profil.setProfilDescription("profil of lector");
				profil.setProfilName("lector");
				profilSrv.create(profil);

		} catch (final HibernateException he) {
			he.printStackTrace();
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}
	
	@Transactional
	public void createUser(IUserDao userDao, IProfilDao profilDao) {
		UserDto user = null;
		Date now = Calendar.getInstance().getTime();
		String password;
		String email;
		try {
			//insert users
				password = new String("PasswordTest");
				user = new UserDto();
				email = new String("lector@example.com");
				user.setEmail(email);
				user.setFirstname("firstname");
				user.setModificationDate(now);
				user.setCreationDate(now);
				user.setUserLastname("lastname");
				user.setProfil(profilDao.findOne(1));
				user.setPassword(password);
				userDao.createUser(user);

		} catch (final HibernateException he) {
			he.printStackTrace();
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @throws HangTechnicalException
	 */
	public void createStoresDaoTest(IUserService userService, IStoreService storeService) throws HangTechnicalException {
		Store store = null;
		Date now = Calendar.getInstance().getTime();
		//User user = createUser("email@example.com");
		try {
			//insert stores
			for (int i = 0; i < 10; i++) {
				store = new Store();
				store.setCity("Paris"+i);
				store.setCountry("France"+i);
				store.setCreatedAt(now);
				store.setModifiedAt(now);
				store.setPostCode(0000+i);
				store.setStoreAddressFirstLine("131, Boulevard "+i);
				store.setStoreAddressSecondLine("Batiment "+i);
				store.setStoreDescription("store of new things and exciting things "+i);
				store.setStoreName("cool store"+i);
				store.setSurface(Long.valueOf("200"));
				store.setUser(userService.findAll().get(0));
				storeService.create(store);
			}

		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
