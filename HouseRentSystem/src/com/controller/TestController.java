package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/test")
public class TestController {
	@RequestMapping("/mediaaddhouse")
	public String addhouse() {
		return "mediaAddhouse";
	}
}
