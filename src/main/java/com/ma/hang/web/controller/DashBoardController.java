package com.ma.hang.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ma.hang.web.constants.URLRestConstants;

 
/**
 * @author yboujallab
 * Dash board controller 
 *
 */
@Controller
public class DashBoardController {
 
	/**
	 * @return dashboard page
	 */
	@RequestMapping(value = {URLRestConstants.url_root, URLRestConstants.url_dashboard_root }, method = RequestMethod.GET)
	public ModelAndView welcomePage() {
 
		ModelAndView model = new ModelAndView();
		model.addObject("title", "Hang plat Form");
		model.addObject("message", "Welome to hang plat form!");
		model.setViewName("dashboard");
		return model;
 
	}
 
	/**
	 * @param error
	 * @param logout
	 * @return login page
	 */
	@RequestMapping(value = URLRestConstants.url_dashboard_login, method = RequestMethod.GET)
	public ModelAndView login(
		@RequestParam(value = "error", required = false) String error,
		@RequestParam(value = "logout", required = false) String logout) {
 
		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Invalid username and password!");
		}
 
		if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
		}
		model.setViewName("login");
 
		return model;
 
	}
}