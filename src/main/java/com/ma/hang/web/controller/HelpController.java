package com.ma.hang.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

 
/**
 * @author yboujallab
 * Dash board controller 
 *
 */
@Controller
@RequestMapping(value = "/help")
public class HelpController {
 
	/**
	 * @return dashboard page
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView welcomePage() {
 
		ModelAndView model = new ModelAndView();
		model.addObject("title", "Welcome to help page");
		model.addObject("message", "Get help of the hang by contacting the administrator!");
		model.setViewName("useful/help");
		return model;
	}
 
}