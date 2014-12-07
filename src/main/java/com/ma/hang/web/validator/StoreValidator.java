package com.ma.hang.web.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ma.hang.web.form.StoreForm;

public class StoreValidator  implements Validator{

	@Override
	public boolean supports(Class<?> paramClass) {
		// TODO Auto-generated method stub
		return StoreForm.class.equals(paramClass);

	}

	@Override
	public void validate(Object obj, Errors errors) {
		// TODO Auto-generated method stub
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "storeName", "valid.store.name");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "storeDescription", "valid.store.description");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "storeAddressFirstLine", "valid.store.address");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "surface", "valid.surface");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "country", "valid.country");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "city", "valid.city");

	}

	
	
	
}
