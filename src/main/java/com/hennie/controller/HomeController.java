package com.hennie.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class HomeController {
	
private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "login/login";
	}
	
	@RequestMapping(value = "/test/home")
	public String home() {
		return "views/home";
	}
	
	@RequestMapping(value = "/login")
	public String login() {
		return "login/login";
	}
	
	@RequestMapping(value = "/register")
	public String register() {
		return "login/register";
	}
	
	@RequestMapping(value = "/forgotId")
	public String forgotId() {
		return "login/forgotId";
	}
	
	@RequestMapping(value = "/forgotPw")
	public String forgotPw() {
		return "login/forgotPw";
	}
	
	@RequestMapping(value = "/utilities_animation")
	public String utilities_animation() {
		return "utilities_animation";
	}
	
}