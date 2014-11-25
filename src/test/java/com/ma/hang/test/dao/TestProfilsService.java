package com.ma.hang.test.dao;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.hibernate.HibernateException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.ma.hang.core.dto.ProfilDto;
import com.ma.hang.core.entities.Profil;
import com.ma.hang.core.service.IProfilService;


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
public class TestProfilsService {

//	@Autowired
//	private SessionFactory sessionFactory;

	@Autowired
	private IProfilService profilService;

	/***
	 * Profil Creation test Be careful the database is automatically rollbacked
	 * after de tests
	 * **/
	@Test
	public void createProfilsServiceTest() {
		Profil profil = null;
		try {
			//insert profils
			for (int i = 0; i < 10; i++) {
				profil = new Profil();
				profil.setProfilDescription("profil of administrataion" + i);
				profil.setProfilName("administrator" + i);
				this.profilService.create(profil);
			}
			//Check insertion 
			List<Profil> listProfil = this.profilService.findAll();
			assertThat(10, equalTo(listProfil.size()));

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
	 * **/
	@Test
	public void createProfilsServiceTestKo_nameNull() {
		Profil profil = null;
		try {
			//insert profils
			for (int i = 0; i < 10; i++) {
				profil = new Profil();
				profil.setProfilDescription("profil of administrataion" + i);
				this.profilService.create(profil);
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
	 * find profil by id test 
	 * Be careful the database is automatically rollbacked
	 * after de tests
	 * **/
	@Test
	public void findByIdProfilsServiceTest() {
		Profil profil = null;
		String profilDescritpion = "profil of administrataion 1";
		String profilName = "administrator1";
		try {
			//insert profils
			profil = new Profil();
			profil.setProfilDescription(profilDescritpion);
			profil.setProfilName(profilName);
			this.profilService.create(profil);
			//Check insertion 
			Profil profilInserted = this.profilService.findOne(profil.getIdProfil());
			assertThat(profilName, equalTo(profilInserted.getProfilName()));
			assertThat(profilDescritpion, equalTo(profilInserted.getProfilDescription()));
		} catch (final HibernateException he) {
			he.printStackTrace();
			fail();
		} catch (final Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	/***
	 * delete profil by id test 
	 * Be careful the database is automatically rollbacked
	 * after de tests
	 * **/
	@Test
	public void deleteProfilByIdServiceTest() {
		Profil profil = null;
		String profilDescritpion = "profil of administrataion 2";
		String profilName = "administrator2";
		try {
			//insert profils
			profil = new Profil();
			profil.setProfilDescription(profilDescritpion);
			profil.setProfilName(profilName);
			this.profilService.create(profil);
			//Check insertion 
			Profil profilInserted = this.profilService.findOne(profil.getIdProfil());
			assertThat(profilName, equalTo(profilInserted.getProfilName()));
			assertThat(profilDescritpion, equalTo(profilInserted.getProfilDescription()));
			//Delete profil
			this.profilService.deleteById(profilInserted.getIdProfil());
			profilInserted = this.profilService.findOne(profilInserted.getIdProfil());
			//check 
			Assert.assertNull(profilInserted);
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
	 * **/
	@Test
	public void updateProfilsServiceTest() {
		Profil profil = null;
		String profilDescritpion = "profil of administrataion 2";
		String profilName = "administrator2";

		try {
			//insert profils
			profil = new Profil();
			profil.setProfilDescription(profilDescritpion);
			profil.setProfilName(profilName);
			this.profilService.create(profil);
			//Check insertion 
			Profil profilInserted = this.profilService.findOne(profil.getIdProfil());
			assertThat(profilName, equalTo(profilInserted.getProfilName()));
			assertThat(profilDescritpion, equalTo(profilInserted.getProfilDescription()));
			//modify profil
			profilInserted.setProfilDescription(profilDescritpion+"mod");
			profilInserted.setProfilName(profilName+"mod");
			this.profilService.create(profilInserted);
			//check modification
			profilInserted = this.profilService.findOne(profil.getIdProfil());
			assertThat(profilName+"mod", equalTo(profilInserted.getProfilName()));
			assertThat(profilDescritpion+"mod", equalTo(profilInserted.getProfilDescription()));
		} catch (final HibernateException he) {
			he.printStackTrace();
			fail();
		} catch (final Exception e) {
			e.printStackTrace();
			fail();
		}
	}	
	/***
	 * delete profil by id test 
	 * Be careful the database is automatically rollbacked
	 * after de tests
	 * **/
	@Test
	public void deleteProfilByEntityServiceTest() {
		Profil profil = null;
		String profilDescritpion = "profil of administrataion 3";
		String profilName = "administrator3";
		try {
			//insert profils
			profil = new Profil();
			profil.setProfilDescription(profilDescritpion);
			profil.setProfilName(profilName);
			this.profilService.create(profil);
			//Check insertion 
			Profil profilInserted = this.profilService.findOne(profil.getIdProfil());
			assertThat(profilName, equalTo(profilInserted.getProfilName()));
			assertThat(profilDescritpion, equalTo(profilInserted.getProfilDescription()));
			//Delete profil
			this.profilService.delete(profilInserted);
			profilInserted = this.profilService.findOne(profilInserted.getIdProfil());
			//check 
			Assert.assertNull(profilInserted);
		} catch (final HibernateException he) {
			he.printStackTrace();
			fail();
		} catch (final Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	/***
	 * find profil by id test 
	 * Be careful the database is automatically rollbacked
	 * after de tests
	 * **/
	@Test
	public void findByCriteriaProfilsServiceTest() {
		Profil profil1 = null;
		Profil profil2 = null;
		Profil profil3 = null;
		
		String profilDescritpion1 = "profil of administrataion 1-1";
		String profilName1 = "administrator1-1";
		String profilDescritpion2 = "profil of administrataion 1-2";
		String profilName2 = "administrator1-2";
		String profilDescritpion3 = "profil of administrataion 3";
		String profilName3 = "administrator3";

		
		ProfilDto profilBean1 = null;
		ProfilDto profilBean2 = null;
		ProfilDto profilBean3 = null;
		ProfilDto profilBeanNoResults = null;
		ProfilDto profilBeanAllResults = null;
		ProfilDto profilBeanResults = null;

		try {
			//insert profil 1 
			profil1 = new Profil();
			profil1.setProfilDescription(profilDescritpion1);
			profil1.setProfilName(profilName1);
			this.profilService.create(profil1);
			//insert profil 2 
			profil2 = new Profil();
			profil2.setProfilDescription(profilDescritpion2);
			profil2.setProfilName(profilName2);
			this.profilService.create(profil2);
			//insert profil 3 
			profil3 = new Profil();
			profil3.setProfilDescription(profilDescritpion3);
			profil3.setProfilName(profilName3);
			this.profilService.create(profil3);
			
			//check find by criteria test 1 (one result)
			profilBean1 = new ProfilDto(profilDescritpion1, profilName1);
			List<Profil> listResults1 = this.profilService.findByCriteria(profilBean1);
			assertThat(1, equalTo(listResults1.size()));
			assertThat(profilName1, equalTo(listResults1.get(0).getProfilName()));
			assertThat(profilDescritpion1, equalTo(listResults1.get(0).getProfilDescription()));
			
			//check find by criteria test 2 (one result)
			profilBean2 = new ProfilDto(profilDescritpion2, profilName2);
			List<Profil> listResults2 = this.profilService.findByCriteria(profilBean2);
			assertThat(1, equalTo(listResults2.size()));
			assertThat(profilName2, equalTo(listResults2.get(0).getProfilName()));
			assertThat(profilDescritpion2, equalTo(listResults2.get(0).getProfilDescription()));
			 
			//check find by criteria test 3 (one result)
			profilBean3 = new ProfilDto(profilDescritpion3, profilName3);
			List<Profil> listResults3 = this.profilService.findByCriteria(profilBean3);
			assertThat(1, equalTo(listResults3.size()));
			assertThat(profilName3, equalTo(listResults3.get(0).getProfilName()));
			assertThat(profilDescritpion3, equalTo(listResults3.get(0).getProfilDescription()));
			
			//check find by criteria test 4 (no result)
			profilBeanNoResults = new ProfilDto("profil no results", "no results");
			List<Profil> listResults4 = this.profilService.findByCriteria(profilBeanNoResults);
			assertThat(0, equalTo(listResults4.size()));
			
			//check find by criteria test 5 (all results)
			profilBeanAllResults = new ProfilDto("profil of administrataion", "administrator");
			List<Profil> listResults5 = this.profilService.findByCriteria(profilBeanAllResults);
			assertThat(3, equalTo(listResults5.size()));
			
			//check find by criteria test 6 (2 results)
			profilBeanResults = new ProfilDto();
			profilBeanResults.setProfilDescription("profil of administrataion 1");
			List<Profil> listResults6 = this.profilService.findByCriteria(profilBeanResults);
			assertThat(2, equalTo(listResults6.size()));
			
			//check find by criteria test 7 (2 results)
			profilBeanResults = new ProfilDto();
			profilBeanResults.setProfilName("administrator1");
			List<Profil> listResults7 = this.profilService.findByCriteria(profilBeanResults);
			assertThat(2, equalTo(listResults7.size()));
			
			//check find by criteria test 5 (all results)
			profilBeanAllResults = new ProfilDto("profil of administrataion 1", "administrator1");
			List<Profil> listResults8 = this.profilService.findByCriteria(profilBeanAllResults);
			assertThat(2, equalTo(listResults8.size()));
			
		} catch (final HibernateException he) {
			he.printStackTrace();
			fail();
		} catch (final Exception e) {
			e.printStackTrace();
			fail();
		}
	}
}
