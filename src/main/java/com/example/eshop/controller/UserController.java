package com.example.eshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

	@GetMapping("/home")
	public String userHome() {
		return "home";
	}
	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}
}
