package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping("")
	public String viewHomePage() {
		return "index";
	}
	
	@GetMapping("/admin/login")
	public String viewAdminLoginPage() {
		return "admin/admin_login";
	}
	
	@GetMapping("/user/login")
	public String viewUserLoginPage() {
		return "user/user_login";
	}
}


