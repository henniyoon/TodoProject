package com.hennie.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j // 로그
public class HomeController {
	
	@RequestMapping("/")
	public String home() {
		log.info("home controller");
		return "views/home";
	}
	
	@RequestMapping("/blank")
	public String blank() {
		log.info("home controller");
		return "views/blank";
	}
	
	@RequestMapping("/errors")
	public String error() {
		log.info("home controller");
		return "views/blank";
	}

}
