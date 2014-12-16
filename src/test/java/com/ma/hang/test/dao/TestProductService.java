package com.ma.hang.test.dao;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.hibernate.HibernateException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.ma.hang.core.dto.UserDto;
import com.ma.hang.core.entities.Product;
import com.ma.hang.core.entities.Profil;
import com.ma.hang.core.entities.Supplier;
import com.ma.hang.core.entities.User;
import com.ma.hang.core.exception.HangTechnicalException;
import com.ma.hang.core.service.IProductService;
import com.ma.hang.core.service.IProfilService;
import com.ma.hang.core.service.ISupplierService;
import com.ma.hang.core.service.IUserService;


/**
 * @author yboujallab
 * class test service
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:core-context-test-hibernate.xml",
		"classpath:core-context-test-dao.xml",
		"classpath:core-context-test-service.xml"})
@Transactional
public class TestProductService {

	@Autowired
	private IProductService prodSrv;
	
	@Autowired
	private IUserService usrSrv;
	
	@Autowired
	private IProfilService prfSrv;
	
	@Autowired
	private ISupplierService supSrv;

	
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
		this.prfSrv.create(profil);
		//create user
		UserDto user = null;
		Date now = Calendar.getInstance().getTime();
		String password;
		String email;
		List<Profil> listProfils = prfSrv.findAll();
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
		usrSrv.createUser(user);
		return usrSrv.findByEmail(emailUser);
	}

	/**
	 * @param emailUser
	 * @return user created
	 * @throws HangTechnicalException
	 */
	public void createSupplier(User user, Supplier sup) {
		//create profil 
		sup.setActivity("activity");
		sup.setName("sup 1");
		sup.setUser(user);
		this.supSrv.create(sup);
	}
	/***
	 * Profil Creation test Be careful the database is automatically rollbacked
	 * after de tests
	 * @throws HangTechnicalException 
	 * **/
	@Test
	public void createProductsTest_OK() throws HangTechnicalException {
		Product product = null;
		Date now = Calendar.getInstance().getTime();
		Supplier sup = new Supplier();
		User user = createUser("email@example.com");
		createSupplier(user, sup);
		List<Product> listProductExpected = new ArrayList<Product>();
		try {
			//insert products
			for (int i = 0; i < 10; i++) {
				product = new Product();
				product.setName("product"+i);
				product.setCapacity(i);
				product.setUnity("ml");
				product.setBoxCapacity(33);
				product.setCreatedAt(now);
				product.setModifiedAt(now);
				product.setSupplier(sup);
				this.prodSrv.create(product);
				listProductExpected.add(product);
			}
			//Check insertion 
			List<Product> listProducts = this.prodSrv.findAllByUser(user);
			assertThat(10, equalTo(listProducts.size()));
			Iterator<Product>  iterExpected = listProductExpected.iterator();
			while(iterExpected.hasNext()){
				if (!listProducts.contains(iterExpected.next()))
					fail();;
			}

		} catch (final HibernateException he) {
			he.printStackTrace();
			fail();
		} catch (final Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	/***
	 * Profil Creation test Be careful the database is automatically rollbacked
	 * after de tests
	 * @throws HangTechnicalException 
	 * **/
	@Test
	public void createProductsTest_nameNull() throws HangTechnicalException {
		Product product = null;
		Date now = Calendar.getInstance().getTime();
		Supplier sup = new Supplier();
		User user = createUser("email@example.com");
		createSupplier(user, sup);
		List<Product> listProductExpected = new ArrayList<Product>();
		try {
			//insert products
			for (int i = 0; i < 10; i++) {
				product = new Product();
				product.setCapacity(i);
				product.setUnity("ml");
				product.setBoxCapacity(33);
				product.setCreatedAt(now);
				product.setModifiedAt(now);
				product.setSupplier(sup);
				this.prodSrv.create(product);
				listProductExpected.add(product);
			}
			//Check insertion 
				fail();
		} catch (ConstraintViolationException e) {
			//e.printStackTrace();
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			if (violations.size() > 1)
				fail();
			Iterator<ConstraintViolation<?>> iter =  violations.iterator();
			ConstraintViolation<?> violationInError = iter.next();
				String msgTemplate = violationInError.getMessageTemplate();
				assertThat("{javax.validation.constraints.NotNull.message}", equalTo(msgTemplate));
		}
	}	
}
