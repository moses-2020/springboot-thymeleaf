package com.moses.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.moses.pojo.Product;

@Controller
public class HelloController {

	@RequestMapping("/test")
	public String hello(Model m){
		
		Product p = new Product();
		p.setName("product 0");
		m.addAttribute("p", p);
		m.addAttribute("html", "<p style='color:red'> 红色文字</p>");
		m.addAttribute("hello", "hello SpringBoot Thymeleat");
		return "test";
	}
}
