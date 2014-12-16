package com.ma.hang.web.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ma.hang.web.form.ProductForm;

/**
 * @author yboujallab
 * Validator of store forms
 *
 */
public class ProductValidator  implements Validator{

	private Pattern pattern;  
	private Matcher matcher; 
    String INTEGER_PATTERN= "[0-9]+";  
	String FLOAT_PATTERN=  "[0-9]*\\.?[0-9]+";
	@Override
	public boolean supports(Class<?> paramClass) {
		// TODO Auto-generated method stub
		return ProductForm.class.equals(paramClass);

	}

	@Override
	public void validate(Object target, Errors errors) {
		 pattern = Pattern.compile(INTEGER_PATTERN);  

		ProductForm prdtForm = (ProductForm) target;
		if(prdtForm.getBoxCapacity().trim() != null && !prdtForm.getBoxCapacity().isEmpty()){
			matcher = pattern.matcher(prdtForm.getBoxCapacity().toString());  
			 if (!matcher.matches()) 
				    errors.rejectValue("boxCapacity", "valid.not.numeric");  
				   else
					   if(Float.valueOf(prdtForm.getBoxCapacity()) <= 0)
						    errors.rejectValue("boxCapacity", "valid.not.negative");  
		}
		if(prdtForm.getCapacity().trim() != null && !prdtForm.getCapacity().isEmpty()){
			matcher = pattern.matcher(prdtForm.getCapacity().toString());  
			 if (!matcher.matches()) 
				    errors.rejectValue("capacity", "valid.not.numeric");  
				   else
					   if(Float.valueOf(prdtForm.getCapacity()) <= 0)
						    errors.rejectValue("capacity", "valid.not.negative");  
		}
		if(prdtForm.getQteMin().trim() != null && !prdtForm.getQteMin().isEmpty()){
			matcher = pattern.matcher(prdtForm.getQteMin().toString());  
			 if (!matcher.matches()) 
				    errors.rejectValue("qteMin", "valid.not.numeric");  
				   else
					   if(Float.valueOf(prdtForm.getQteMin()) <= 0)
						    errors.rejectValue("qteMin", "valid.not.negative");  
		}
		   if("NONE".equals(prdtForm.getIdSupplier())){
				errors.rejectValue("idSupplier", "valid.product.supplier");
			   }
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "valid.product.name");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "capacity", "valid.product.capacity");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "unity", "valid.product.unity");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "boxCapacity", "valid.product.box.capacity");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "qteMin", "valid.product.qte.minimum");

	}
	
}
