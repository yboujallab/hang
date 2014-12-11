package com.ma.hang.web.controller;

import java.security.Principal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
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
	
    @Autowired
    @Qualifier("storeValidator")
    private Validator validator;
	  
    @InitBinder
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(validator);
        binder.registerCustomEditor(Float.TYPE, new CustomNumberEditor(Float.class, false));
    }
    
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
		model.addObject("storeForm", new StoreForm()); 

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
	 * @param model 
	 * @return add page
	 */
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String viewAdd(Map<String, Object> model) {
		StoreForm storeForm = new StoreForm();
		model.put("storeForm", storeForm);
		return "stores/add_store";
	}
	
	 /**
	 * @param storeForm
	 * @param result
	 * @param model 
	 * @param principal 
	 * @return model end view
	 */

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String saveStore(@Validated @ModelAttribute("storeForm") StoreForm storeForm,
			BindingResult result, Map<String, Object> model,Principal principal) {
		Date now = Calendar.getInstance().getTime();
		if (result.hasErrors()) {
			return "stores/add_store";
		}
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
		storeToAdd.setSurface(Float.valueOf(storeForm.getSurface()));
		com.ma.hang.core.entities.User currentUser = userService.findByEmail(principal.getName());
		storeToAdd.setUser(currentUser);
		storeService.create(storeToAdd);
		storeForm.setCreatedAt(storeToAdd.getCreatedAt());
		storeForm.setModifiedAt(storeToAdd.getModifiedAt());
		storeForm.setIdStore(storeToAdd.getIdStore());
	    return "stores/show_store";	
	    }
	
	/**
	 * @param idStore 
	 * @return stores page
	 */
	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public ModelAndView showStore(@RequestParam("idStore") int idStore) {
		Store storeDetails = storeService.findOne(idStore);	
		StoreForm storeForm = new StoreForm();
		storeForm.setIdStore(storeDetails.getIdStore());
		storeForm.setCity(storeDetails.getCity());
		storeForm.setCountry(storeDetails.getCountry());
		storeForm.setModifiedAt(storeDetails.getModifiedAt());
		storeForm.setPostCode(storeDetails.getPostCode());
		storeForm.setStoreAddressFirstLine(storeDetails.getStoreAddressFirstLine());
		storeForm.setStoreAddressSecondLine(storeDetails.getStoreAddressSecondLine());
		storeForm.setStoreDescription(storeDetails.getStoreDescription());
		storeForm.setStoreName(storeDetails.getStoreName());
		storeForm.setSurface(String.valueOf(storeDetails.getSurface()));
		storeForm.setCreatedAt(storeDetails.getCreatedAt());
		ModelAndView model = new ModelAndView();
		model.addObject("storeForm", storeForm);
		model.setViewName("stores/show_store");
	    return model;

	}
	
	/**
	 * @param idStore 
	 * @return stores page
	 */
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public ModelAndView updateStore(@RequestParam("idStore") int idStore) {
		Store storeDetails = storeService.findOne(idStore);	
		StoreForm storeForm = new StoreForm();
		storeForm.setIdStore(storeDetails.getIdStore());
		storeForm.setCity(storeDetails.getCity());
		storeForm.setCountry(storeDetails.getCountry());
		storeForm.setModifiedAt(storeDetails.getModifiedAt());
		storeForm.setPostCode(storeDetails.getPostCode());
		storeForm.setStoreAddressFirstLine(storeDetails.getStoreAddressFirstLine());
		storeForm.setStoreAddressSecondLine(storeDetails.getStoreAddressSecondLine());
		storeForm.setStoreDescription(storeDetails.getStoreDescription());
		storeForm.setStoreName(storeDetails.getStoreName());
		storeForm.setSurface(String.valueOf(storeDetails.getSurface()));
		storeForm.setCreatedAt(storeDetails.getCreatedAt());
		ModelAndView model = new ModelAndView();
		model.addObject("storeForm", storeForm);
		model.setViewName("stores/update_store");
	    return model;

	}
	/**
	 * @param storeForm 
	 * @param result 
	 * @param model 
	 * @return stores page update
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateStore(@Validated @ModelAttribute("storeForm") StoreForm storeForm,BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "stores/update_store";
		}
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
		storeToUpdate.setSurface(Float.valueOf(storeForm.getSurface()));
		storeService.create(storeToUpdate);
		StoreForm storeFormUpdated = new StoreForm();
		storeFormUpdated.setIdStore(storeToUpdate.getIdStore());
		storeFormUpdated.setCity(storeToUpdate.getCity());
		storeFormUpdated.setCountry(storeToUpdate.getCountry());
		storeFormUpdated.setModifiedAt(storeToUpdate.getModifiedAt());
		storeFormUpdated.setPostCode(storeToUpdate.getPostCode());
		storeFormUpdated.setStoreAddressFirstLine(storeToUpdate.getStoreAddressFirstLine());
		storeFormUpdated.setStoreAddressSecondLine(storeToUpdate.getStoreAddressSecondLine());
		storeFormUpdated.setStoreDescription(storeToUpdate.getStoreDescription());
		storeFormUpdated.setStoreName(storeToUpdate.getStoreName());
		storeFormUpdated.setSurface(String.valueOf(storeToUpdate.getSurface()));
		storeFormUpdated.setCreatedAt(storeToUpdate.getCreatedAt());
		model.addAttribute("storeForm",storeFormUpdated);
	    return "stores/show_store";
	}
	/**
	 * @param idStore 
	 * @param model 
	 * @return stores page search
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String deleteStore(@RequestParam("idStore") int idStore, Model model) {
		storeService.deleteById(idStore);
		List<Store> listStore = storeService.findAll();
		model.addAttribute("listStore",listStore);
	    return "stores/search";
	}	
	@RequestMapping(value = "/back", method = RequestMethod.POST)
	public String rateHandler(HttpServletRequest request) {
	    //your controller code
	    String referer = request.getHeader("Referer");
	    return "redirect:"+ referer;
	}
	
}