package com.cignex.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cignex.entities.Screen;
import com.cignex.services.ScreenService;

@Controller
@RequestMapping("/screen")
public class ScreenController {
	@Autowired
	private ScreenService screenService;

	@RequestMapping("/new")
	private String newScreen(Model model) {
		Screen screen = new Screen();
		model.addAttribute("screen", screen);
		return "screen/register";
	}

	@PostMapping("/save")
	private String saveScreen(@ModelAttribute("screen") Screen screen,
			@RequestParam("platiniumSeats") String platiniumSeats, @RequestParam("silverSeats") String silverSeats,
			@RequestParam("goldSeats") String goldSeats, HttpServletRequest request) {
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
		return "redirect:/screen/list";
	}

	@GetMapping("/list")
	private String getAllSeats(Model model) {
		List<Screen> list = screenService.getAllList();
		System.out.println(list.size());
		model.addAttribute("list", list);
		return "screen/allScreen";
	}

	@GetMapping("/get")
	private String getScreenById(@RequestParam("id") int id, Model model) {
		Screen screen = screenService.getScreenById(id);
		model.addAttribute("screen", screen);
		return "screen/update";
	}

	@GetMapping("/delete/{id}")
	private String deleteScreen(@PathVariable int id) {
		Screen screen = screenService.getScreenById(id);
		screenService.delete(screen);
		return "redirect:/screen/list";
	}

}
