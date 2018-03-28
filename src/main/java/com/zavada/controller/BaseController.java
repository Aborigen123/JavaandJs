package com.zavada.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.zavada.domain.LoginRequest;
import com.zavada.domain.RegisterRequest;
import com.zavada.mapper.UserMapper;
import com.zavada.service.UserService;

@Controller
public class BaseController {
	
	@Autowired private UserService userService;
	
	@GetMapping({"/", "/home"})
	public String shoHome() {
		return "home";
	}
	
	@GetMapping("/products")
	public String showLogin() {
		
		return"products";
	}
	
	@GetMapping("/login")
	public String showLogin(Model model) {
		model.addAttribute("loginModel", new LoginRequest());
		return "login";
	}
	
	@GetMapping("/register")
	public String showRegister(Model model) {
		model.addAttribute("registerModel", new RegisterRequest());
		return "register";
	}
	
	@PostMapping("/register")
	public String createUser(
			@ModelAttribute("registerModel") @Valid RegisterRequest registerRequest,
			BindingResult result) {
		
		if(result.hasErrors()) {
			return "register";
		}
		
		userService.saveUser(UserMapper.registerToUser(registerRequest));
		
		return "redirect:/login";
	}
		
}
