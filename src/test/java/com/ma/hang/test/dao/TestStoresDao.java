package com.ma.hang.test.dao;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.ma.hang.core.dao.IProfilDao;
import com.ma.hang.core.dao.IStoreDao;
import com.ma.hang.core.dao.IUserDao;
import com.ma.hang.core.dto.UserDto;
import com.ma.hang.core.entities.Profil;
import com.ma.hang.core.entities.Store;
import com.ma.hang.core.entities.User;
import com.ma.hang.core.exception.HangTechnicalException;

/**
 * @author yboujallab
 * Test class of profils
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:core-context-test-hibernate.xml",
		"classpath:core-context-test-dao.xml" })
@Transactional
public class TestStoresDao {

	@Autowired
	private IStoreDao storeDao;
	
	@Autowired
	private IUserDao userDao;
	
	@Autowired
	private IProfilDao profilDao;

	/**
	 * @param emailUser
	 * @return user created
	 * @throws HangTechnicalException
	 */
	public User createUser(String emailUser) throws HangTechnicalException{
		//create profil 
		Profil profil = new Profil();
		profil.setProfilDescription("profil of administrataion");
		profil.setProfilName("administrator");
		this.profilDao.create(profil);
		//create user
		UserDto user = null;
		Date now = Calendar.getInstance().getTime();
		String password;
		String email;
		List<Profil> listProfils = profilDao.findAll();
		password = new String("Password");
		user = new UserDto();
		email = new String(emailUser);
		user.setEmail(email);
		user.setFirstname("firstname");
		user.setModificationDate(now);
		user.setCreationDate(now);
		user.setUserLastname("lastname");
		user.setProfil(listProfils.get(0));
		user.setPassword(password);
		userDao.createUser(user);
		return userDao.findByEmail(emailUser);
	}
	
	/**
	 * @throws HangTechnicalException
	 */
	@Test
	public void createStoresDaoTest() throws HangTechnicalException {
		Store store = null;
		Date now = Calendar.getInstance().getTime();
		User user = createUser("email@example.com");
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
				store.setUser(user);
				this.storeDao.create(store);
			}
			//Check insertion 
			List<Store> listStores = this.storeDao.findAll();
			assertThat(10, equalTo(listStores.size()));

		}catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
}
