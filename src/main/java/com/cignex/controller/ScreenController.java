package com.cignex.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.cignex.entities.Screen;
import com.cignex.exception.ScreenNotFoundException;
import com.cignex.services.ScreenService;

@RestController
@RequestMapping("/screen")
@SessionAttributes({ "name", "id", "role","email" })
public class ScreenController {
	@Autowired
	private ScreenService screenService;

	@RequestMapping("/new")
	private ModelAndView newScreen(ModelAndView model) {
		Screen screen = new Screen();
		model.addObject("screen", screen);
		model.setViewName("screen/register");
		return model;
	}

	@PostMapping("/save")
	private ModelAndView saveScreen(@ModelAttribute("screen") Screen screen,
			@RequestParam("platiniumSeats") String platiniumSeats, @RequestParam("silverSeats") String silverSeats,
			@RequestParam("goldSeats") String goldSeats, HttpServletRequest request, ModelAndView model) {
		int g = Integer.parseInt(goldSeats);
		int s = Integer.parseInt(silverSeats);
		int p = Integer.parseInt(platiniumSeats);
		List<String> plist = new ArrayList<String>();
		List<String> glist = new ArrayList<String>();
		List<String> slist = new ArrayList<String>();
		for (int i = 1; i <= p; i++) {
			plist.add("p" + i);
			System.out.println("p" + i);

		}
		for (int i = 1; i <= g; i++) {
			glist.add("g" + i);

		}
		for (int i = 1; i <= s; i++) {
			slist.add("s" + i);

		}
		screen.setPlatiniumSeats(plist.toArray(new String[p]));
		screen.setGoldSeats(glist.toArray(new String[g]));
		screen.setSilverSeats(slist.toArray(new String[s]));
		screenService.save(screen);
		model.setViewName("redirect:/screen/list");
		return model;
	}

	@GetMapping("/list")
	private ModelAndView getAllSeats(ModelAndView model) {
		List<Screen> list = screenService.getAllList();
		if (list == null) {
			throw new ScreenNotFoundException("Sreens are not founded");
		}
		model.addObject("list", list);
		model.setViewName("screen/allScreen");
		return model;
	}

	@GetMapping("/get/{id}")
	private ModelAndView getScreenById(@PathVariable("id") int id, ModelAndView model) {
		Screen screen = screenService.getScreenById(id);
		if (screen == null) {
			throw new ScreenNotFoundException(" screen is not found with id " + id);
		}
		model.addObject("screen", screen);
		model.setViewName("screen/update");
		return model;
	}

	@GetMapping("/delete/{id}")
	private ModelAndView deleteScreen(@PathVariable int id, ModelAndView model) {
		Screen screen = screenService.getScreenById(id);
		if (screen == null) {
			throw new ScreenNotFoundException(" screen is not found with id " + id);
		}
		screenService.delete(screen);
		model.setViewName("redirect:/screen/list");
		return model;
	}

}
