package com.cignex.controller;

import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.cignex.entities.Movie;
import com.cignex.entities.Screen;
import com.cignex.entities.Show;
import com.cignex.services.BookSeatsService;
import com.cignex.services.MovieService;
import com.cignex.services.ScreenService;

@RestController
@RequestMapping("/book")
public class BookSeatsController {
	@Autowired
	private ScreenService screenService;

	@Autowired
	private MovieService movieService;
	@Autowired
	private BookSeatsService bookSeatService;

	@GetMapping("/setShow")
	private ModelAndView SetShow(ModelAndView model) {
		Show setshow = new Show();
		List<Movie> list = movieService.getAllMovie();
		model.addObject("list", list);
		List<Screen> slist = screenService.getAllList();
		model.addObject("slist", slist);
		model.addObject("setshow", setshow);
		model.setViewName("booking/setMovie");
		return model;
	}

	@PostMapping("/save")
	private ModelAndView show(ModelAndView model, @RequestParam("totalShow") int total, @RequestParam("movieName") String movieName,
			@RequestParam("screen") String screen, HttpServletRequest request, @RequestParam("date") Date date) {
		request.setAttribute("movieName", movieName);
		model.addObject("total", total);
		model.addObject("screen", screen);
		model.addObject("date", date);
		model.setViewName("booking/showmanagement");
		return model;

	}

	@PostMapping("/shows")
	private ModelAndView finalShowSet(ModelAndView model, @ModelAttribute("shows") Show show, @RequestParam("count") int count,
			HttpServletRequest request, @RequestParam("movieName") int id, @RequestParam("screen") int sid,
			@RequestParam("date") Date date) {
		Movie movie = movieService.getMovieById(id);
		Screen screen = screenService.getScreenById(sid);
		String[] gseat = screen.getGoldSeats();
		String[] pseat = screen.getPlatiniumSeats();
		String[] sseat = screen.getSilverSeats();
		List<String[]> s = new ArrayList<String[]>();
		s.add(sseat);
		s.add(pseat);
		s.add(gseat);
		model.addObject("s", s);
		count = Integer.parseInt(request.getParameter("count"));
		show.setMovie(movie);
		show.setScreen(screen);
		show.setDate(date);
		for (int i = 1; i <= count; i++) {
			Time time = Time.valueOf(request.getParameter("showTime" + i) + ":00");
			show.setTime(time);
			show.setPlatiniumPrice(Integer.parseInt(request.getParameter("platiniumprice" + i)));
			show.setSilverPrice(Integer.parseInt(request.getParameter("silverPrice" + i)));
			show.setGoldPrice(Integer.parseInt(request.getParameter("goldPrice" + i)));
			show.setId(i);
			bookSeatService.save(show);
		}
		model.setViewName("redirect:/book/getMovieShows");
		return model;
	}

	
	@GetMapping("/getMovieShows")
	public ModelAndView getMovieShows(ModelAndView model) {
		List<Show> slist = bookSeatService.getAllShows();
		model.addObject("slist", slist);
		model.setViewName("booking/totalShow");
		return model;
	}

	@GetMapping("/getShow")
	public ModelAndView getMovieShowById(int id, ModelAndView model){
		Show show = bookSeatService.getShowById(id);
		model.addObject("show", show);
		model.setViewName("booking/getShow");
		return model;
	}

	@PostMapping("/bookT")
	public ModelAndView bookSeats(@ModelAttribute("show") Show show, ModelAndView model,HttpServletRequest request) {
		show=bookSeatService.getShowById(show.getId());
		List<String> seats=new ArrayList<>();
		if(show.getBookedSeats()!=null) {
			for(String s:show.getBookedSeats()) {
				seats.add(s);
			}
		}
		Map<String, String[]> parameters=request.getParameterMap();
		parameters.forEach((k,v)->{
			if(k.contains("p")) seats.add(v[0].toString());
			if(k.contains("g")) seats.add(v[0].toString());
			if(k.contains("s")) seats.add(v[0].toString());
		});
		String[] bookedSeats = seats.stream().toArray(String[]::new);
		bookSeatService.upShowById(show.getId(), bookedSeats);
		model.setViewName("redirect:/book/getMovieShows");
		return model;
	}

}
