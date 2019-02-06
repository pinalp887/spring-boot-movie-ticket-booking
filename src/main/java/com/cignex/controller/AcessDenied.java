package com.cignex.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.cignex.entities.CustomUserDetails;
import com.cignex.services.MyUserDetailsService;

@RestController
@SessionAttributes({ "name", "id", "role", "email" })
public class AcessDenied {
	@Autowired
	private MyUserDetailsService userService;

	@GetMapping("/login")
	public ModelAndView login(ModelAndView model, String error, String logout) {
		if (error != null)
			model.addObject("msg", "Your username and password are invalid.");

		if (logout != null)
			model.addObject("msg", "You have been logged out successfully.");
		model.setViewName("login");
		return model;
	}

	@GetMapping("/welcome")
	public ModelAndView getUser(ModelAndView model, Authentication principal) {
		CustomUserDetails details = (CustomUserDetails) principal.getPrincipal();
		model.addObject("name", details.getUsername());
		model.addObject("id", details.getId());
		model.addObject("role", details.getAuthorities());
		model.setViewName("header");
		return model;
	}

	@PostMapping("/login-process")
	public ModelAndView process(ModelAndView model, HttpServletRequest request) {
		/*
		 * String username=request.getParameter("username");
		 * System.out.println("in process"); System.out.println(username); UserDetails
		 * user=userService.loadUserByUsername(username);
		 * System.out.println(user.toString());
		 */
		model.setViewName("redirect:/book/datewise");
		return model;
	}

	@GetMapping("/acess-denied")
	public ModelAndView getAccess(ModelAndView model) {
		model.setViewName("main");
		return model;
	}

	@GetMapping("/logout-sucess")
	public ModelAndView logOut(ModelAndView model) {
		model.setViewName("redirect:/login");
		return model;
	}
}
