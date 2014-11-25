package com.ma.hang.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ma.hang.core.entities.Store;
import com.ma.hang.core.service.IStoreService;
import com.ma.hang.web.constants.URLRestConstants;

 
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
	
	/**
	 * @return stores page
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView welcomePage() {
		ModelAndView model = new ModelAndView();
		List<Store> listStore = storeService.findAll();
		model.addObject("listStore",listStore);
		model.setViewName("stores");
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
		return model;
	}
	
}