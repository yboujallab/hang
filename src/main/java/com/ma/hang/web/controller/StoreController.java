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
		model.setViewName("stores");
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
		model.setViewName("stores");
		model.addObject("storeForm", new StoreForm()); // the Category object is used as a template to generate the form

		return model;
	}
	
	
	 /**
	 * @param storeForm
	 * @param result
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}