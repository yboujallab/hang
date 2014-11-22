package com.ma.hang.test.dao;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import static org.junit.Assert.assertTrue;




import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.ma.hang.core.dao.IProfilDao;
import com.ma.hang.core.dao.IUserDao;
import com.ma.hang.core.dto.UserDto;
import com.ma.hang.core.entities.Profil;
import com.ma.hang.core.entities.User;
import com.ma.hang.core.util.PasswordService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:core-context-test-hibernate.xml",
		"classpath:core-context-test-dao.xml" })
@Transactional
public class TestUsersDao {

//	@Autowired
//	private SessionFactory sessionFactory;

	@Autowired
	private IUserDao userDao;
	
	@Autowired
	private IProfilDao profilDao;

	/***
	 * Profil Creation test Be careful the database is automatically rollbacked
	 * after de tests
	 * **/
	
	public void insertProfils(){
		Profil profil = null;
		try {
			//insert profils
			for (int i = 0; i < 10; i++) {
				profil = new Profil();
				profil.setProfilDescription("profil of administrataion" + i);
				profil.setProfilName("administrator" + i);
				profilDao.create(profil);
			}
			//Check insertion 
			List<Profil> listProfil = this.profilDao.findAll();
			assertThat(10, equalTo(listProfil.size()));

		} catch (final HibernateException he) {
			he.printStackTrace();
			fail();
		} catch (final Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	@Test
	public void createUsersTest() {
		insertProfils();
		UserDto user = null;
		Date now = Calendar.getInstance().getTime();
		String password;
		String email;
		try {
			//insert users
			for (int i = 0; i < 10; i++) {
				password = new String("Password"+i);
				user = new UserDto();
				email = new String("email"+i+"@example.com");
				user.setEmail(email);
				user.setFirstname("firstname" + i);
				user.setModificationDate(now);
				user.setCreationDate(now);
				user.setUserLastname("lastname" + i);
				user.setIdprofil(i+1);
				user.setPassword(password);
				userDao.createUser(user);
				//check authentication
				//boolean isauthok = userDao.authenticate(email, password);
				assertTrue(userDao.authenticate(email, password));
			}
			//Check insertion 
			List<User> listUsers = this.userDao.findAll();
			assertThat(10, equalTo(listUsers.size()));

		} catch (final HibernateException he) {
			he.printStackTrace();
			fail();
		} catch (final Exception e) {
			e.printStackTrace();
			fail();
		}
	}
}
