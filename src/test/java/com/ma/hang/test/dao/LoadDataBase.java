package com.ma.hang.test.dao;

import java.util.Calendar;
import java.util.Date;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ma.hang.core.dao.IProfilDao;
import com.ma.hang.core.dao.IStoreDao;
import com.ma.hang.core.dao.IUserDao;
import com.ma.hang.core.dto.UserDto;
import com.ma.hang.core.entities.Profil;
import com.ma.hang.core.entities.Store;
import com.ma.hang.core.exception.HangTechnicalException;

public class LoadDataBase {


public static void main(String[] args) throws HangTechnicalException {
	
	
    ApplicationContext context = new ClassPathXmlApplicationContext("load-data-context.xml");
    IUserDao userdao = (IUserDao) context.getBean("userDao");
    IProfilDao profildao = (IProfilDao) context.getBean("profilDao");
    IStoreDao storeDao = (IStoreDao) context.getBean("storeDao");
    LoadDataBase load = new LoadDataBase();
    //load.createUser(userdao, profildao);
    load.createStoresDaoTest(userdao, storeDao);
}
	
	public void insertProfils(IProfilDao profilDao ){
		Profil profil = null;
		try {
			//insert profils
				profil = new Profil();
				profil.setProfilDescription("profil of administrataion");
				profil.setProfilName("administrator");
				profilDao.create(profil);

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
				password = new String("Password");
				user = new UserDto();
				email = new String("emailtest@example.com");
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
	@Transactional
	public void createStoresDaoTest(IUserDao userDao, IStoreDao storeDao) throws HangTechnicalException {
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
				store.setUser(userDao.findAll().get(0));
				storeDao.create(store);
			}

		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
