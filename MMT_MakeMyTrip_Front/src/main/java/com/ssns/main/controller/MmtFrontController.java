package com.ssns.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MmtFrontController {

	@RequestMapping("/")
	public String toHome() {
		String hm = "home";
		return "home";
	}

}
