package com.cignex.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.cignex.constant.Constant;
import com.cignex.entities.CustomUserDetails;
import com.cignex.entities.Movie;
import com.cignex.entities.Screen;
import com.cignex.entities.Show;
import com.cignex.entities.User;
import com.cignex.entities.UserBooked;
import com.cignex.exception.ShowNotFoundException;
import com.cignex.services.BookSeatsService;
import com.cignex.services.EmailService;
import com.cignex.services.MovieService;
import com.cignex.services.ScreenService;
import com.cignex.services.UserBookedService;
import com.cignex.services.UserService;

@RestController
@RequestMapping("/book")
@SessionAttributes({ "name", "id", "role","email" })
public class BookSeatsController {
	@Autowired
	private ScreenService screenService;
	@Autowired
	private UserService userService;
	@Autowired
	private MovieService movieService;
	@Autowired
	private BookSeatsService bookSeatService;
	@Autowired
	private UserBookedService bookService;
	@Autowired
	private EmailService emailService;

	@GetMapping("/setShow")
	private ModelAndView SetShow(ModelAndView model) {
		Show setshow = new Show();
		List<Movie> list = movieService.getAllMovie();
		System.out.println(list.size());
		model.addObject("list", list);
		List<Screen> slist = screenService.getAllList();
		model.addObject("slist", slist);
		model.addObject("setshow", setshow);
		model.setViewName("booking/setMovie");
		return model;
	}

	@PostMapping("/save")
	private ModelAndView show(ModelAndView model, @RequestParam("totalShow") int total,
			@RequestParam("movieName") String movieName, @RequestParam("screen") String screen,
			HttpServletRequest request, @RequestParam("date") Date date) {
		request.setAttribute("movieName", movieName);
		model.addObject("total", total);
		model.addObject("screen", screen);
		model.addObject("date", date);
		model.setViewName("booking/showmanagement");
		return model;

	}

	@PostMapping("/shows")
	private ModelAndView finalShowSet(ModelAndView model, @ModelAttribute("shows") Show show,
			@RequestParam("count") int count, HttpServletRequest request, @RequestParam("movieName") int id,
			@RequestParam("screen") int sid, @RequestParam("date") Date date) {
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
			System.out.println("in save method");
			bookSeatService.save(show);
		}
		model.setViewName("redirect:/book/datewise");
		return model;
	}

	@GetMapping("/getMovieShows")
	public ModelAndView getMovieShows(ModelAndView model) {
		List<Show> slist = bookSeatService.getAllShows();
		if(slist.isEmpty()) {
			throw new ShowNotFoundException("There were no show founded");
		}
		model.addObject("slist", slist);
		model.setViewName("booking/totalShow");
		return model;
	}

	@GetMapping("/getShow")
	public ModelAndView getMovieShowById(int id, ModelAndView model) {
		Show show = bookSeatService.getShowById(id);
		
		model.addObject("show", show);
		model.setViewName("booking/getShow");
		return model;
	}

	@PostMapping("/bookT")
	public ModelAndView bookSeats(@ModelAttribute("show") Show show, ModelAndView model, HttpServletRequest request,ModelMap map) throws AddressException, MessagingException {
		show = bookSeatService.getShowById(show.getId());
		List<String> seats = new ArrayList<>();
		if (show.getBookedSeats() != null) {
			for (String s : show.getBookedSeats()) {
				seats.add(s);
			}
		}
		List<String> ubSeats=new ArrayList<>();
		Map<String, String[]> uparameters = request.getParameterMap();
		uparameters.forEach((k, v) -> {
			if (k.contains("p"))
				ubSeats.add(v[0].toString());
			if (k.contains("g"))
				ubSeats.add(v[0].toString());
			if (k.contains("s"))
				ubSeats.add(v[0].toString());
		});
		String[] ubookedSeats = ubSeats.stream().toArray(String[]::new);
		Map<String, String[]> parameters = request.getParameterMap();
		parameters.forEach((k, v) -> {
			if (k.contains("p"))
				seats.add(v[0].toString());
			if (k.contains("g"))
				seats.add(v[0].toString());
			if (k.contains("s"))
				seats.add(v[0].toString());
		});
		int f=Integer.parseInt(request.getParameter("t"));
		String[] bookedSeats = seats.stream().toArray(String[]::new);
		int id=(int) map.get("id");
		String email=(String) map.get("email");
		User user=userService.getUserById(id);
		UserBooked booked=new UserBooked();
		booked.setUser(user);
		booked.setMovie(show.getMovie());
		booked.setScreen(show.getScreen());
		booked.setDate(show.getDate());
		booked.setTime(show.getTime());
		booked.setBookedSeats(ubookedSeats);
		booked.setShow(show);
		booked.setTotal(f);
		bookService.save(booked);
		emailService.ticketSendMail(show.getMovie().getName(),show.getScreen().getScreenName(), show.getDate(),show.getTime(), ubookedSeats, f, email);
		bookSeatService.upShowById(show.getId(), bookedSeats);
		System.out.println(seats);
		System.out.println(ubSeats);
		model.setViewName("redirect:/book/datewise");
		return model;
	}

	@GetMapping("/datewise")
	public ModelAndView getShows(ModelAndView model, Authentication authentication) throws IOException {
		CustomUserDetails details = (CustomUserDetails) authentication.getPrincipal();
		model.addObject("name", details.getUsername());
		model.addObject("id", details.getId());
		model.addObject("role", details.getAuthorities());
		model.addObject("email", details.getEmail());
		List<Movie> list = movieService.getAllMovie();
		model.addObject("list", list);
		String imgString = null;
		for (Movie movie : list) {
			File file = new File(movie.getMoviePath().toString());
			byte[] byteImg = Files.readAllBytes(file.toPath());
			imgString = Base64.encodeBase64String(byteImg);
			movie.setMoviePath(imgString);
		}
		model.setViewName("booking/dateWiseShow");
		return model;
	}

	@PostMapping("/getDatewise")
	public ModelAndView getDateWise(ModelAndView model, HttpServletRequest request) throws ParseException {
		Date date = Date.valueOf(request.getParameter("date"));
		List<Show> show = bookSeatService.getMovieByDate(Integer.parseInt(request.getParameter("id")), date);
		
		System.out.println(show);
		if(show.isEmpty()) {
			throw new ShowNotFoundException("no show found on the date of "+date);
		}
		model.addObject("show", show);
		model.setViewName("booking/totalShow");
		return model;
	}
}
