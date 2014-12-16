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

import com.ma.hang.core.dao.IProductDao;
import com.ma.hang.core.dao.IProfilDao;
import com.ma.hang.core.dao.ISupplierDao;
import com.ma.hang.core.dao.IUserDao;
import com.ma.hang.core.dto.UserDto;
import com.ma.hang.core.entities.Product;
import com.ma.hang.core.entities.Profil;
import com.ma.hang.core.entities.Supplier;
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
public class TestProductDao {

	@Autowired
	private IProductDao productDao;
	
	@Autowired
	private IUserDao userDao;
	
	@Autowired
	private IProfilDao profilDao;

	@Autowired
	private ISupplierDao supDao;
	
	
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
	 * @param emailUser
	 * @return user created
	 * @throws HangTechnicalException
	 */
	public void createSupplier(User user, Supplier sup) {
		//create profil 
		sup.setActivity("activity");
		sup.setName("sup 1");
		sup.setUser(user);
		this.supDao.create(sup);
	}
	/**
	 */
	@Test
	public void createProductsDaoTest() throws HangTechnicalException {
		Product product = null;
		Date now = Calendar.getInstance().getTime();
		User user = createUser("email@example.com");
		Supplier sup = new Supplier();
		createSupplier(user, sup);
		try {
			//insert stores
			for (int i = 0; i < 10; i++) {
				product = new Product();
				product.setName("product"+i);
				product.setCapacity(i);
				product.setUnity("ml");
				product.setBoxCapacity(33);
				product.setCreatedAt(now);
				product.setModifiedAt(now);
				product.setSupplier(sup);
				this.productDao.create(product);
			}
			//Check insertion 
			List<Product> listProducts = this.productDao.findAllByUser(user);
			assertThat(listProducts.size(), equalTo(10));
		}catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
}
