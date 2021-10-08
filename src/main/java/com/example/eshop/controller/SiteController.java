package com.example.eshop.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.eshop.model.Product;
import com.example.eshop.service.ProductService;

@Controller
public class SiteController {

	@Autowired
	ProductService productService;

	@GetMapping("/")
	public String home(HttpServletRequest req, HttpServletResponse res) {
		if (req.getUserPrincipal() != null)
			return "home";
		else
			return "redirect:/login";
	}

	@GetMapping("/contact_us")
	public String contactUs() {
		return "contact_us";
	}

	@GetMapping("/about_us")
	public String aboutUs() {
		return "about_us";
	}

	@GetMapping("/product/list")
	public String productList(HttpServletRequest req, HttpServletResponse res) {
		List<Product> plist = productService.getData();
		System.out.println("plist.size()-"+plist.size());
		req.setAttribute("plist", plist );
		return "list";
	}

}
