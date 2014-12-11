package com.ma.hang.web.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ma.hang.web.form.SupplierForm;

public class SupplierValidator  implements Validator{

	private Pattern pattern;  
	private Matcher matcher; 
	String INTEGER_PATTERN= "[0-9]+";  
	//String FLOAT_PATTERN=  "[0-9]*\\.?[0-9]+";
	@Override
	public boolean supports(Class<?> paramClass) {
		// TODO Auto-generated method stub
		return SupplierForm.class.equals(paramClass);

	}

	@Override
	public void validate(Object target, Errors errors) {
		
		SupplierForm supForm = (SupplierForm) target;
		if (supForm.getPostCode().trim() != null && !supForm.getPostCode().isEmpty()){
			 pattern = Pattern.compile(INTEGER_PATTERN);  
			 matcher = pattern.matcher(supForm.getPostCode().toString());  
			   if (!matcher.matches()) 
			    errors.rejectValue("postCode", "valid.not.numeric");  
/*			   else
				   if(Integer.valueOf(supForm.getPostCode()) < 0)
					    errors.rejectValue("surface", "valid.post.code.not.negative");  
*/
		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "valid.sup.name");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "valid.sup.description");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "activity", "valid.sup.activity");

	}
	
}
