package com.cignex.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class AcessDenied {

	@GetMapping("/acess-denied")
	public ModelAndView getAccess(ModelAndView model) {
		model.setViewName("main");
		return model;
	}
}
