package com.form.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class UserController {
	
	public Model SetUser(Model model){
		model.addAttribute("user", "soojin");
		
		return model;
	}
}
