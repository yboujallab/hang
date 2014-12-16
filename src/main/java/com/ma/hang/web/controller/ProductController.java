package com.ma.hang.web.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ch.qos.logback.classic.Logger;

import com.ma.hang.core.entities.Product;
import com.ma.hang.core.entities.Supplier;
import com.ma.hang.core.service.IProductService;
import com.ma.hang.core.service.ISupplierService;
import com.ma.hang.core.service.IUserService;
import com.ma.hang.web.constants.URLRestConstants;
import com.ma.hang.web.form.ProductForm;

 
/**
 * @author yboujallab
 * Dash board controller 
 *
 */
@Controller
@RequestMapping(value = URLRestConstants.url_product_root)
public class ProductController {
 	
	final static Logger LOGGER = (Logger) LoggerFactory
			.getLogger(ProductController.class);
	
	@Autowired
	private IProductService productSrv;
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private ISupplierService supSrv;
	
    @Autowired
    @Qualifier("productValidator")
    private Validator validator;
	  
    @InitBinder
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(validator);
    }
    
 
	/**
	
	/**
	 * @param principal 
	 * @return stores page
	 */
	@RequestMapping(value ="/findAll", method = RequestMethod.GET)
	public ModelAndView findAllProducts(Principal principal) {
		com.ma.hang.core.entities.User currentUser = userService.findByEmail(principal.getName());
		ModelAndView model = new ModelAndView();
		model.addObject("productForm", new ProductForm()); 
		List<Product> list = new ArrayList<Product>();
		//List<Product> listProducts = productSrv.findAllByUser(currentUser);
		Iterator<Supplier> iterSup = currentUser.getSuppliers().iterator();
		while(iterSup.hasNext()){
			list.addAll(iterSup.next().getProducts());
		}
		model.addObject("listProducts",list);
		model.setViewName("products/search");
		return model;
	}
	
	/**
	 * @param model 
	 * @return add page
	 */
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String viewAdd(Map<String, Object> model,Principal principal) {
		com.ma.hang.core.entities.User currentUser = userService.findByEmail(principal.getName());
		Map<Integer,String> mapSup = new LinkedHashMap<Integer,String>();
		List<Supplier> listSuppliers = currentUser.getSuppliers();
		Iterator<Supplier> iterator = listSuppliers.iterator();
		Supplier supplier = null;
		while(iterator.hasNext()){
			supplier = iterator.next();
			mapSup.put(supplier.getIdSupplier(), supplier.getName());
		}
		//model.put("mapSup", mapSup);
		ProductForm productForm = new ProductForm();
		productForm.setMapSup(mapSup);
		model.put("productForm", productForm);
		return "products/add_product";
	}

	 /**
		 * @param supForm 
		 * @param result
		 * @param model 
		 * @param principal 
		 * @return model end view
		 */

		@RequestMapping(value = "/add", method = RequestMethod.POST)
		public String saveSupplier(@Validated @ModelAttribute("productForm") ProductForm productForm,
				BindingResult result, Map<String, Object> model,Principal principal) {
			Date now = Calendar.getInstance().getTime();
			if (result.hasErrors()) {
				return "products/add_product";
			}
			Product productToAdd = new Product();
			if(productForm.getBoxCapacity().trim() != null && !productForm.getBoxCapacity().isEmpty())
					productToAdd.setBoxCapacity(Integer.valueOf(productForm.getBoxCapacity()));
			if(productForm.getCapacity().trim() != null && !productForm.getCapacity().isEmpty())
				productToAdd.setCapacity(Integer.valueOf(productForm.getCapacity()));
			if(productForm.getQteMin().trim() != null && !productForm.getQteMin().isEmpty())
				productToAdd.setQteMin(Integer.valueOf(productForm.getQteMin()));
			productToAdd.setName(productForm.getName());
			productToAdd.setDescription(productForm.getDescription());
			productToAdd.setUnity(productForm.getUnity());
			productToAdd.setCreatedAt(now);
			productToAdd.setModifiedAt(now);
			productToAdd.setSupplier(supSrv.findOne(Integer.valueOf(productForm.getIdSupplier())));
			productSrv.create(productToAdd);
		    return "products/add_product";	
		    }
}