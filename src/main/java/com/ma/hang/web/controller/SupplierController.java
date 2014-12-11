package com.ma.hang.web.controller;

import java.security.Principal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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

import com.ma.hang.core.entities.Supplier;
import com.ma.hang.core.service.ISupplierService;
import com.ma.hang.core.service.IUserService;
import com.ma.hang.web.constants.URLRestConstants;
import com.ma.hang.web.form.SupplierForm;

 
/**
 * @author yboujallab
 * Dash board controller 
 *
 */
@Controller
@RequestMapping(value = URLRestConstants.url_supplier_root)
public class SupplierController {
 
	
	@Autowired
	private ISupplierService supService;

	@Autowired
	private IUserService userService;

    @Autowired
    @Qualifier("supplierValidator")
    private Validator validator;
	
    @InitBinder
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(validator);
    }
	/**
	 * @return root supplier page
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView welcomePage() {
		ModelAndView model = new ModelAndView();
		model.setViewName("suppliers/suppliers");
		return model;
	}
	/**
	 * @return fine all page
	 */
	@RequestMapping(value ="/findAll", method = RequestMethod.GET)
	public ModelAndView findAllSuppliers() {
		ModelAndView model = new ModelAndView();
		List<Supplier> listSuppliers = supService.findAll();
		model.addObject("listSuppliers",listSuppliers);
		model.setViewName("suppliers/search");
		return model;
	}

	/**
	 * @param model 
	 * @return add page
	 */
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String viewAdd(Map<String, Object> model) {
		SupplierForm supForm = new SupplierForm();
		model.put("supForm", supForm);
		return "suppliers/add_supplier";
	}
	
	/**
	 * @param idStore 
	 * @return stores page
	 */
	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public ModelAndView showSupplier(@RequestParam("idSup") int idSupplier) {
		Supplier supDetails = supService.findOne(idSupplier);	
		SupplierForm supForm = new SupplierForm();
		supForm.setActivity(supDetails.getActivity());
		supForm.setAddress(supDetails.getAddress());
		supForm.setCity(supDetails.getCity());
		supForm.setCountry(supDetails.getCountry());
		supForm.setCreationDate(supDetails.getCreationDate());
		supForm.setDescription(supDetails.getDescription());
		supForm.setIdSupplier(supDetails.getIdSupplier());
		supForm.setModificationDate(supDetails.getModificationDate());
		supForm.setName(supDetails.getName());
		supForm.setPostCode(String.valueOf(supDetails.getPostCode()));
		ModelAndView model = new ModelAndView();
		model.addObject("supForm", supForm);
		//model.addAttribute("supForm", supForm);
		model.setViewName("suppliers/show_supplier");
	    return model;

	}
	
	 /**
	 * @param supplier Form
	 * @param result
	 * @param model 
	 * @param principal 
	 * @return model end view
	 */

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String saveSupplier(@Validated @ModelAttribute("supForm") SupplierForm supForm,
			BindingResult result, Map<String, Object> model,Principal principal) {
		Date now = Calendar.getInstance().getTime();
		if (result.hasErrors()) {
			return "suppliers/add_supplier";
		}
		Supplier supToAdd = new Supplier();
		supToAdd.setActivity(supForm.getActivity());
		supToAdd.setAddress(supForm.getAddress());
		supToAdd.setCity(supForm.getCity());
		supToAdd.setCountry(supForm.getCountry());
		supToAdd.setCreationDate(now);
		supToAdd.setModificationDate(now);
		supToAdd.setDescription(supForm.getDescription());
		supToAdd.setName(supForm.getName());
		if (supForm.getPostCode().trim() != null && !supForm.getPostCode().isEmpty())
		supToAdd.setPostCode(Integer.valueOf(supForm.getPostCode()));
		com.ma.hang.core.entities.User currentUser = userService.findByEmail(principal.getName());
		supToAdd.setUser(currentUser);
		supService.create(supToAdd);
		supForm.setIdSupplier(supToAdd.getIdSupplier());
		supForm.setCreationDate(supToAdd.getCreationDate());
		supForm.setModificationDate(supToAdd.getModificationDate());
	    return "suppliers/show_supplier";	
	    }
	
	/**
	 * @param idStore 
	 * @param model 
	 * @return stores page search
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String deleteStore(@RequestParam("idSup") int idSupplier, Model model) {
		supService.deleteById(idSupplier);
		List<Supplier> listSuppliers = supService.findAll();
		model.addAttribute("listSuppliers",listSuppliers);
	    return "suppliers/search";
	}	
	/**
	 * @param idStore 
	 * @return stores page
	 */
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String updateStore(@RequestParam("idSup") int idSupplier, Model model) {
		Supplier supDetails = supService.findOne(idSupplier);	
		SupplierForm supForm = new SupplierForm();
		supForm.setActivity(supDetails.getActivity());
		supForm.setAddress(supDetails.getAddress());
		supForm.setCity(supDetails.getCity());
		supForm.setCountry(supDetails.getCountry());
		supForm.setCreationDate(supDetails.getCreationDate());
		supForm.setDescription(supDetails.getDescription());
		supForm.setIdSupplier(supDetails.getIdSupplier());
		supForm.setModificationDate(supDetails.getModificationDate());
		supForm.setName(supDetails.getName());
		supForm.setPostCode(String.valueOf(supDetails.getPostCode()));
		model.addAttribute("supForm", supForm);
	    return "suppliers/update_supplier";
	}	
	/**
	 * @param storeForm 
	 * @param result 
	 * @param model 
	 * @return stores page update
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateStore(@Validated @ModelAttribute("supForm") SupplierForm supForm,BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "suppliers/update_supplier";
		}
		Supplier supplierToUpdate = supService.findOne(supForm.getIdSupplier());	
		Date now = Calendar.getInstance().getTime();
		supplierToUpdate.setActivity(supForm.getActivity());
		supplierToUpdate.setAddress(supForm.getAddress());
		supplierToUpdate.setCity(supForm.getCity());
		supplierToUpdate.setCountry(supForm.getCountry());
		supplierToUpdate.setModificationDate(now);
		supplierToUpdate.setDescription(supForm.getDescription());
		supplierToUpdate.setName(supForm.getName());
		if (supForm.getPostCode().trim() != null && !supForm.getPostCode().isEmpty())
			supplierToUpdate.setPostCode(Integer.valueOf(supForm.getPostCode()));
/*		StoreForm storeFormUpdated = new StoreForm();
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
		storeFormUpdated.setCreatedAt(storeToUpdate.getCreatedAt());*/
		supForm.setModificationDate(supplierToUpdate.getModificationDate());
		model.addAttribute("storeForm",supForm);
	    return "suppliers/show_supplier";
	}	
}