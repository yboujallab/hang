package com.ma.hang.test.dao;

import java.util.Calendar;
import java.util.Date;

import org.hibernate.HibernateException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.ma.hang.core.dao.IProfilDao;
import com.ma.hang.core.dao.IUserDao;
import com.ma.hang.core.dto.UserDto;
import com.ma.hang.core.entities.Profil;

public class LoadDataBase {


public static void main(String[] args) {
	
	
    ApplicationContext context = new ClassPathXmlApplicationContext("load-data-context.xml");
    IUserDao userdao = (IUserDao) context.getBean("userDao");
    IProfilDao profildao = (IProfilDao) context.getBean("profilDao");
    LoadDataBase load = new LoadDataBase();
    load.createUser(userdao);
    
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
	public void createUser(IUserDao userDao) {
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
				user.setIdprofil(1);
				user.setPassword(password);
				userDao.createUser(user);

		} catch (final HibernateException he) {
			he.printStackTrace();
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}
}
