package com.revature.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/LoginController")

public class LoginController {
	
	@GetMapping("/")
	public String hello() {
		return "index";
	}
	
	@GetMapping("/Login")
	public String hello(Model model) {
		return "Login";
	}
	
	@RequestMapping(value = "LoginOn", method = RequestMethod.GET)
	public ModelAndView hello(@RequestParam("uname") String username, @RequestParam("pass") String password) {
		return new ModelAndView("Success","Result","Welcome" + username);
	}
	
}
