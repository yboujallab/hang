package com.ma.hang.test.dao;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.hibernate.HibernateException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.ma.hang.core.dto.UserDto;
import com.ma.hang.core.entities.Profil;
import com.ma.hang.core.entities.User;
import com.ma.hang.core.exception.HangTechnicalException;
import com.ma.hang.core.service.IProfilService;
import com.ma.hang.core.service.IUserService;

/**
 * @author yboujallab
 *
 * Class test of users
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:core-context-test-hibernate.xml",
		"classpath:core-context-test-dao.xml",
		"classpath:core-context-test-service.xml"})
@Transactional
public class TestUserService {


	@Autowired
	private IUserService userService;
	
	@Autowired
	private IProfilService profilService;

	/***
	 * Profil Creation test Be careful the database is automatically rollbacked
	 * after de tests
	 * **/
	@Before
	public  void insertProfils(){
		Profil profil = null;
		try {
			List<Profil> listProfil = profilService.findAll();
			//delete profils
			if (!listProfil.isEmpty()){
				Iterator<Profil> iter = listProfil.iterator();
				while(iter.hasNext()){
					profil = iter.next();
					profilService.delete(profil);
				}
			}
			//insert profils
			for (int i = 0; i < 10; i++) {
				profil = new Profil();
				profil.setProfilDescription("profil of administrataion" + i);
				profil.setProfilName("administrator" + i);
				profilService.create(profil);
			}
			//Check insertion 
			listProfil = profilService.findAll();
			assertThat(listProfil.size(), equalTo(10));
		} catch (final HibernateException he) {
			he.printStackTrace();
			fail();
		} catch (final Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	/**
	 * test create and authenticate users
	 */
	@Test
	public void createUsersServiceTestOk() {
		UserDto user = null;
		Date now = Calendar.getInstance().getTime();
		String password;
		String email;
		List<Profil> listProfils = profilService.findAll();
		
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
				user.setProfil(listProfils.get(0));
				user.setPassword(password);
				userService.createUser(user);
				//check authentication
				//boolean isauthok = userDao.authenticate(email, password);
				assertNotNull(userService.authenticate(email, password));
			}
			//Check insertion 
			List<User> listUsers = this.userService.findAll();
			assertThat(10, equalTo(listUsers.size()));

		} catch (HibernateException he) {
			he.printStackTrace();
			fail();
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	/**
	 * test create user with a null email
	 */
	@Test
	public void createUsersServiceTestKo_emailNull() {
		UserDto user = null;
		Date now = Calendar.getInstance().getTime();
		String password;
		List<Profil> listProfils = profilService.findAll();

		try {
			//insert users
				password = new String("Password");
				user = new UserDto();
				user.setFirstname("firstname");
				user.setModificationDate(now);
				user.setCreationDate(now);
				user.setUserLastname("lastname");
				user.setProfil(listProfils.get(0));
				user.setPassword(password);
				userService.createUser(user);
				fail();
		} catch (ConstraintViolationException e) {
			e.printStackTrace();
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			if (violations.size() > 1)
				fail();
			Iterator<ConstraintViolation<?>> iter =  violations.iterator();
			ConstraintViolation<?> violationInError = iter.next();
				String msgTemplate = violationInError.getMessageTemplate();
				assertThat("{javax.validation.constraints.NotNull.message}", equalTo(msgTemplate));
		} catch (HangTechnicalException e) {
			assertThat("Erro while saving user", equalTo(e.getMessage()));
			assertTrue(e.getCause() instanceof ConstraintViolationException);
			ConstraintViolationException exp = (ConstraintViolationException) e.getCause();
			Set<ConstraintViolation<?>> violations = exp.getConstraintViolations();
			if (violations.size() > 1)
				fail();
			Iterator<ConstraintViolation<?>> iter =  violations.iterator();
			ConstraintViolation<?> violationInError = iter.next();
				String msgTemplate = violationInError.getMessageTemplate();
				assertThat("{javax.validation.constraints.NotNull.message}", equalTo(msgTemplate));
		} 
	}

	/**
	 * test create user with a null profil
	 */
	@Test
	public void createUsersServiceTestKo_profilNull() {
		UserDto user = null;
		Date now = Calendar.getInstance().getTime();
		String password;

		try {
			//insert users
				password = new String("Password");
				user = new UserDto();
				user.setFirstname("firstname");
				user.setModificationDate(now);
				user.setCreationDate(now);
				user.setUserLastname("lastname");
				user.setEmail("email");
				user.setPassword(password);
				userService.createUser(user);
				fail();
		}  catch (HangTechnicalException e) {
			assertThat("Erro while saving user", equalTo(e.getMessage()));
			assertTrue(e.getCause() instanceof ConstraintViolationException);
			ConstraintViolationException exp = (ConstraintViolationException) e.getCause();
			Set<ConstraintViolation<?>> violations = exp.getConstraintViolations();
			if (violations.size() > 1)
				fail();
			Iterator<ConstraintViolation<?>> iter =  violations.iterator();
			ConstraintViolation<?> violationInError = iter.next();
				String msgTemplate = violationInError.getMessageTemplate();
				assertThat("{javax.validation.constraints.NotNull.message}", equalTo(msgTemplate));

		} 
	}
	/**
	 * test create user with a null first name
	 */
	@Test
	public void createUsersServiceTestKo_firstNameNull() {
		UserDto user = null;
		Date now = Calendar.getInstance().getTime();
		String password;
		List<Profil> listProfils = profilService.findAll();

		try {
			//insert users
				password = new String("Password");
				user = new UserDto();
				user.setProfil(listProfils.get(0));
				user.setModificationDate(now);
				user.setCreationDate(now);
				user.setUserLastname("lastname");
				user.setEmail("email");
				user.setPassword(password);
				userService.createUser(user);
				fail();
		} catch (HangTechnicalException e) {
			assertThat("Erro while saving user", equalTo(e.getMessage()));
			assertTrue(e.getCause() instanceof ConstraintViolationException);
			ConstraintViolationException exp = (ConstraintViolationException) e.getCause();
			Set<ConstraintViolation<?>> violations = exp.getConstraintViolations();
			if (violations.size() > 1)
				fail();
			Iterator<ConstraintViolation<?>> iter =  violations.iterator();
			ConstraintViolation<?> violationInError = iter.next();
				String msgTemplate = violationInError.getMessageTemplate();
				assertThat("{javax.validation.constraints.NotNull.message}", equalTo(msgTemplate));
		} 
	}
	/**
	 * test create user with a null last name
	 */
	@Test
	public void createUsersServiceTestKo_lastNameNull() {
		UserDto user = null;
		Date now = Calendar.getInstance().getTime();
		String password;
		List<Profil> listProfils = profilService.findAll();

		try {
			//insert users
				password = new String("Password");
				user = new UserDto();
				user.setProfil(listProfils.get(0));
				user.setModificationDate(now);
				user.setCreationDate(now);
				user.setFirstname("firstname");
				user.setEmail("email");
				user.setPassword(password);
				userService.createUser(user);
				fail();
		} catch (HangTechnicalException e) {
			assertThat("Erro while saving user", equalTo(e.getMessage()));
			assertTrue(e.getCause() instanceof ConstraintViolationException);
			ConstraintViolationException exp = (ConstraintViolationException) e.getCause();
			Set<ConstraintViolation<?>> violations = exp.getConstraintViolations();
			if (violations.size() > 1)
				fail();
			Iterator<ConstraintViolation<?>> iter =  violations.iterator();
			ConstraintViolation<?> violationInError = iter.next();
				String msgTemplate = violationInError.getMessageTemplate();
				assertThat("{javax.validation.constraints.NotNull.message}", equalTo(msgTemplate));
		} 
	}	
	
	/**
	 * test create user with a null password
	 */
	@Test
	public void createUsersServiceTestKo_pwdNull() {
		UserDto user = null;
		Date now = Calendar.getInstance().getTime();
		List<Profil> listProfils = profilService.findAll();
		try {
			//insert users
				user = new UserDto();
				user.setProfil(listProfils.get(0));
				user.setModificationDate(now);
				user.setCreationDate(now);
				user.setFirstname("firstname");
				user.setEmail("email");
				user.setUserLastname("last name");
				userService.createUser(user);
				fail();
		} catch (HangTechnicalException e) {
			e.printStackTrace();
			assertThat("Erro while saving user", equalTo(e.getMessage()));
			assertTrue(e.getCause().getCause() instanceof NullPointerException);
		} 
	}		
	
	/**
	 * test create user with a null password
	 */
	@Test
	public void createUsersServiceTestKo_allNull() {
		UserDto user = null;
		Date now = Calendar.getInstance().getTime();
		try {
				//insert users
				user = new UserDto();
				user.setModificationDate(now);
				user.setCreationDate(now);
				user.setPassword("password");
				userService.createUser(user);
				fail();
		}  catch (HangTechnicalException e) {
			assertThat("Erro while saving user", equalTo(e.getMessage()));
			assertTrue(e.getCause() instanceof ConstraintViolationException);
			ConstraintViolationException exp = (ConstraintViolationException) e.getCause();
			Set<ConstraintViolation<?>> violations = exp.getConstraintViolations();
			if (violations.size() != 4)
				fail();
			Iterator<ConstraintViolation<?>> iter =  violations.iterator();
			ConstraintViolation<?> violationInError;
			while (iter.hasNext()){
				violationInError = iter.next();
				String msgTemplate = violationInError.getMessageTemplate();
				assertThat("{javax.validation.constraints.NotNull.message}", equalTo(msgTemplate));
		} 
	}

	}
}
