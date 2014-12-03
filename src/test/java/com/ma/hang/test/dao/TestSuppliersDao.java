package com.ma.hang.test.dao;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertNull;
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

import com.ma.hang.core.dao.ISupplierDao;
import com.ma.hang.core.entities.Supplier;


/**
 * @author yboujallab
 * Test class of suppliers
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:core-context-test-hibernate.xml",
		"classpath:core-context-test-dao.xml" })
@Transactional
public class TestSuppliersDao {


	@Autowired
	private ISupplierDao supplierDao;

	/***
	 * Profil Creation test Be careful the database is automatically rollbacked
	 * after de tests
	 * **/
	@Test
	public void createSuppliersTest_OK() {
		Supplier supplier = null;
		Date now = Calendar.getInstance().getTime();
		List<Supplier> listSupExpected = new ArrayList<Supplier>();
		try {
			//insert suppliers
			for (int i = 0; i < 10; i++) {
				supplier = new Supplier();
				supplier.setActivity("Activity"+1);
				supplier.setAddress("Address"+i);
				supplier.setCreationDate(now);
				supplier.setDescription("Description"+i);
				supplier.setModificationDate(now);
				supplier.setName("Name"+i);
				this.supplierDao.create(supplier);
				listSupExpected.add(supplier);
			}
			//Check insertion 
			List<Supplier> listProfil = this.supplierDao.findAll();
			assertThat(10, equalTo(listProfil.size()));
			Iterator<Supplier>  iterExpected = listSupExpected.iterator();
			while(iterExpected.hasNext()){
				if (!listProfil.contains(iterExpected.next()))
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
	 * Supplier Creation test Be careful the database is automatically rollbacked
	 * after de tests
	 * **/
	@Test
	public void createSuppliersTestDaoKo_nameNull() {
		Supplier supplier = null;
		Date now = Calendar.getInstance().getTime();
		try {
			//insert suppliers
			for (int i = 0; i < 10; i++) {
				supplier = new Supplier();
				supplier.setActivity("Activity"+1);
				supplier.setAddress("Address"+i);
				supplier.setCreationDate(now);
				supplier.setDescription("Description"+i);
				supplier.setModificationDate(now);
				this.supplierDao.create(supplier);
			}
			fail();
		}  catch (ConstraintViolationException e) {
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
	/***
	 * find supplier by id test 
	 * Be careful the database is automatically rollbacked
	 * after de tests
	 * **/
	@Test
	public void findByIdProfilsDaoTest() {
		Supplier supplier = null;
		Date now = Calendar.getInstance().getTime();
		try {
			supplier = new Supplier();
			supplier.setActivity("Activity");
			supplier.setAddress("Address");
			supplier.setCreationDate(now);
			supplier.setDescription("Description");
			supplier.setModificationDate(now);
			supplier.setName("Name");
			this.supplierDao.create(supplier);
			Supplier suppInserted = this.supplierDao.findOne(supplier.getIdSupplier());
			assertThat("Name", equalTo(suppInserted.getName()));
			assertThat("Description", equalTo(suppInserted.getDescription()));
		} catch (final HibernateException he) {
			he.printStackTrace();
			fail();
		} catch (final Exception e) {
			e.printStackTrace();
			fail();
		}
	}	

	/***
	 * delete supplier by id test 
	 * Be careful the database is automatically rollbacked
	 * after de tests
	 * **/
	@Test
	public void deleteSupplierByIdDaoTest() {
		Supplier supplier = null;
		Date now = Calendar.getInstance().getTime();
		try {
			supplier = new Supplier();
			supplier.setActivity("Activity");
			supplier.setAddress("Address");
			supplier.setCreationDate(now);
			supplier.setDescription("Description");
			supplier.setModificationDate(now);
			supplier.setName("Name");
			this.supplierDao.create(supplier);
			//Check insertion 
			Supplier suppInserted = this.supplierDao.findOne(supplier.getIdSupplier());
			assertThat("Name", equalTo(suppInserted.getName()));
			assertThat("Description", equalTo(suppInserted.getDescription()));
			//Delete profil
			this.supplierDao.deleteById(suppInserted.getIdSupplier());
			suppInserted = this.supplierDao.findOne(suppInserted.getIdSupplier());
			//check 
			assertNull(suppInserted);
		} catch (final HibernateException he) {
			he.printStackTrace();
			fail();
		} catch (final Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	/***
	 * supplier Creation test Be careful the database is automatically rollbacked
	 * after de tests
	 * **/
	@Test
	public void updateProfilsDaoTest() {
		Supplier supplier = null;
		Date now = Calendar.getInstance().getTime();
		try {
			supplier = new Supplier();
			supplier.setActivity("Activity");
			supplier.setAddress("Address");
			supplier.setCreationDate(now);
			supplier.setDescription("Description");
			supplier.setModificationDate(now);
			supplier.setName("Name");
			this.supplierDao.create(supplier);
			//Check insertion 
			Supplier supInserted = this.supplierDao.findOne(supplier.getIdSupplier());
			assertThat("Name", equalTo(supInserted.getName()));
			assertThat("Description", equalTo(supInserted.getDescription()));
			//modify suppleir
			supInserted.setDescription("DescriptionMod");
			this.supplierDao.create(supInserted);
			//check modification
			supInserted = this.supplierDao.findOne(supInserted.getIdSupplier());
			assertThat("DescriptionMod", equalTo(supInserted.getDescription()));
		} catch (final HibernateException he) {
			he.printStackTrace();
			fail();
		} catch (final Exception e) {
			e.printStackTrace();
			fail();
		}
	}	
	
	
}
