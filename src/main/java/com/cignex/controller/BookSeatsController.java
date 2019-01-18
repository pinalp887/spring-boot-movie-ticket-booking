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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cignex.entities.Movie;
import com.cignex.entities.Screen;
import com.cignex.entities.Show;
import com.cignex.services.BookSeatsService;
import com.cignex.services.MovieService;
import com.cignex.services.ScreenService;

@Controller
@RequestMapping("/book")
public class BookSeatsController {
	@Autowired
	private ScreenService screenService;

	@Autowired
	private MovieService movieService;
	@Autowired
	private BookSeatsService bookSeatService;

	@GetMapping("/setShow")
	private String SetShow(Model model) {
		Show setshow = new Show();
		List<Movie> list = movieService.getAllMovie();
		model.addAttribute("list", list);
		List<Screen> slist = screenService.getAllList();
		model.addAttribute("slist", slist);
		model.addAttribute("setshow", setshow);
		return "booking/setMovie";
	}

	@PostMapping("/save")
	private String show(Model model, @RequestParam("totalShow") int total, @RequestParam("movieName") String movieName,
			@RequestParam("screen") String screen, HttpServletRequest request, @RequestParam("date") Date date) {
		request.setAttribute("movieName", movieName);
		model.addAttribute("total", total);
		model.addAttribute("screen", screen);
		model.addAttribute("date", date);
		System.out.println(total+" "+screen);
		return "booking/showmanagement";

	}

	@PostMapping("/shows")
	private String finalShowSet(Model model, @ModelAttribute("shows") Show show, @RequestParam("count") int count,
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
		model.addAttribute("s", s);
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
		return "booking/totalShow";
	}

	@GetMapping("/getMovieShows")
	public String getMovieShows(Model model) {
		List<Show> slist = bookSeatService.getAllShows();
		model.addAttribute("slist", slist);
		return "booking/totalShow";
	}

	@GetMapping("/getShow")
	public String getMovieShowById(int id, Model model) throws Exception {
		Show show = bookSeatService.getShowById(id);
		model.addAttribute("show", show);
		return "booking/getShow";
	}

	@PostMapping("/bookT")
	public String bookSeats(@ModelAttribute("show") Show show, Model model,HttpServletRequest request) {
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
		return "redirect:/book/getMovieShows";
	}

}
