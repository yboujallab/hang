package com.ma.hang.web.controller;

import java.security.Principal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ma.hang.core.entities.Store;
import com.ma.hang.core.service.IStoreService;
import com.ma.hang.core.service.IUserService;
import com.ma.hang.web.constants.URLRestConstants;
import com.ma.hang.web.form.StoreForm;

 
/**
 * @author yboujallab
 * Dash board controller 
 *
 */
@Controller
@RequestMapping(value = URLRestConstants.url_stores_root)
public class StoreController {
 	
	@Autowired
	private IStoreService storeService;
	
	@Autowired
	private IUserService userService;
	
	  
	/**
	 * @return stores page
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView welcomePage() {
		ModelAndView model = new ModelAndView();
		List<Store> listStore = storeService.findAll();
		model.addObject("listStore",listStore);
		model.setViewName("stores/stores");
		model.addObject("visibilityAddForm", "hidden");
		model.addObject("storeForm", new StoreForm()); // the Category object is used as a template to generate the form
		return model;
	}
 
	/**
	 * @return stores page
	 */
	@RequestMapping(value = URLRestConstants.url_stores_root, method = RequestMethod.GET)
	public ModelAndView createStore() {
		ModelAndView model = new ModelAndView();
		List<Store> listStore = storeService.findAll();
		model.addObject("listStore",listStore);
		model.setViewName("stores/stores");
		model.addObject("storeForm", new StoreForm()); // the Category object is used as a template to generate the form

		return model;
	}
	
	/**
	 * @return stores page
	 */
	@RequestMapping(value ="/findAll", method = RequestMethod.GET)
	public ModelAndView findAllStore() {
		ModelAndView model = new ModelAndView();
		List<Store> listStore = storeService.findAll();
		model.addObject("listStore",listStore);
		model.setViewName("stores/search");
		return model;
	}
	
	 /**
	 * @param storeForm
	 * @param result
	 * @param principal 
	 * @return model end view
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	    public ModelAndView save(@ModelAttribute("storeForm") StoreForm storeForm, BindingResult result, Principal principal) {
		Date now = Calendar.getInstance().getTime();
		Store storeToAdd = new Store();
		storeToAdd.setCity(storeForm.getCity());
		storeToAdd.setCountry(storeForm.getCountry());
		storeToAdd.setCreatedAt(now);
		storeToAdd.setModifiedAt(now);
		storeToAdd.setPostCode(storeForm.getPostCode());
		storeToAdd.setStoreAddressFirstLine(storeForm.getStoreAddressFirstLine());
		storeToAdd.setStoreAddressSecondLine(storeForm.getStoreAddressSecondLine());
		storeToAdd.setStoreDescription(storeForm.getStoreDescription());
		storeToAdd.setStoreName(storeForm.getStoreName());
		storeToAdd.setSurface(storeForm.getSurface());
		com.ma.hang.core.entities.User currentUser = userService.findByEmail(principal.getName());
		storeToAdd.setUser(currentUser);
		storeService.create(storeToAdd);
	    return new ModelAndView("stores/show_store");
	    }
	
	/**
	 * @param idStore 
	 * @return stores page
	 */
	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public ModelAndView showStore(@RequestParam("idStore") int idStore) {
		Store storeDetails = storeService.findOne(idStore);		
		ModelAndView model = new ModelAndView();
		if (storeDetails != null){
			model.addObject("storeDetails",storeDetails);
		}
		model.addObject("storeForm", new StoreForm());
		model.setViewName("stores/show_store");
	    return model;

	}
	
	/**
	 * @param storeForm 
	 * @return stores page update
	 */
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public ModelAndView updateStore(@ModelAttribute("storeForm") StoreForm storeForm) {
		Store storeToUpdate = storeService.findOne(storeForm.getIdStore());	
		Date now = Calendar.getInstance().getTime();
		storeToUpdate.setCity(storeForm.getCity());
		storeToUpdate.setCountry(storeForm.getCountry());
		storeToUpdate.setModifiedAt(now);
		storeToUpdate.setPostCode(storeForm.getPostCode());
		storeToUpdate.setStoreAddressFirstLine(storeForm.getStoreAddressFirstLine());
		storeToUpdate.setStoreAddressSecondLine(storeForm.getStoreAddressSecondLine());
		storeToUpdate.setStoreDescription(storeForm.getStoreDescription());
		storeToUpdate.setStoreName(storeForm.getStoreName());
		storeToUpdate.setSurface(storeForm.getSurface());
		storeService.create(storeToUpdate);
		ModelAndView model = new ModelAndView();
		model.addObject("storeDetails",storeToUpdate);
		model.addObject("storeForm", new StoreForm());
		model.setViewName("stores/show_store");
	    return model;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}