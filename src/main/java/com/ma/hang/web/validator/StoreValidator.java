package com.ma.hang.web.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ma.hang.web.form.StoreForm;

public class StoreValidator  implements Validator{

	private Pattern pattern;  
	private Matcher matcher; 
	//String SURFACE_PATTERN= "[0-9]+";  
	String FLOAT_PATTERN=  "[0-9]*\\.?[0-9]+";
	@Override
	public boolean supports(Class<?> paramClass) {
		// TODO Auto-generated method stub
		return StoreForm.class.equals(paramClass);

	}

	@Override
	public void validate(Object target, Errors errors) {
		
		StoreForm storeForm = (StoreForm) target;
		if (storeForm.getSurface().trim() != null && !storeForm.getSurface().isEmpty()){
			 pattern = Pattern.compile(FLOAT_PATTERN);  
			 matcher = pattern.matcher(storeForm.getSurface().toString());  
			   if (!matcher.matches()) 
			    errors.rejectValue("surface", "valid.surface.not.numeric");  
			   else
				   if(Float.valueOf(storeForm.getSurface()) < 0)
					    errors.rejectValue("surface", "valid.surface.not.negative");  

		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "storeName", "valid.store.name");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "storeDescription", "valid.store.description");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "storeAddressFirstLine", "valid.store.address");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "surface", "valid.surface");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "country", "valid.country");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "city", "valid.city");

	}
	
}
