package com.form;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ApplicationController {
	@RequestMapping("/")
	public String index(Model model){
		model.addAttribute("login", "Success Login page");
		
		return "index";
	}
	
	@RequestMapping("/hello")
	public String hello(Model model){
		model.addAttribute("message", "sample");
		
		return "hello";
	}
}
