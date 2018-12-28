package com.cignex.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.cignex.constant.Constant;
import com.cignex.entities.Movie;
import com.cignex.repositories.MovieRepository;
import com.cignex.services.MovieService;

@Controller
@RequestMapping(value = Constant.MOVIE_CONTROLLER_REQUEST)
public class MovieController {
	@Autowired
	private MovieService movieService;

	@GetMapping(value = Constant.HOME_PAGE_REQUEST)
	private String home(Model model) {
		Movie movie = new Movie();
		model.addAttribute("movie", movie);
		return Constant.MOVIE_REGISTER_JSP;
	}

	@GetMapping(value = Constant.REGISTER_REQUEST)
	private String register(Model model) {
		Movie movie = new Movie();
		model.addAttribute("movie", movie);
		return Constant.MOVIE_REGISTER_JSP;
	}

	@PostMapping(value = Constant.SAVE_REQUEST)
	private String addMovie(@ModelAttribute("movie") Movie movie, Model model,
			@RequestParam("file") MultipartFile[] files) throws IOException {
		Path path = null;
		String pathh = null;
		for (MultipartFile file : files) {
			pathh = Constant.UPLOAD_DIRECTORY + file.getOriginalFilename();
			path = Paths.get(pathh);
			Files.write(path, file.getBytes());
		}
		movie.setMoviePath(pathh);
		movieService.save(movie);
		return Constant.REDIRECT_MOVIE;
	}

	@GetMapping(value = Constant.GET_ALL_DATA_REQUEST)
	private String getAllMovie(Model model) {
		List<Movie> list=movieService.getAllMovie();
		model.addAttribute("list", list);
		return Constant.LIST_MOVIE_JSP;
	}

	@GetMapping(value = Constant.GET_BY_ID_REQUEST)
	private String getMovieById(@RequestParam("id") int id,Model model) {
		Movie movie=movieService.getMovieById(id);
		model.addAttribute("movie", movie);
		return Constant.UPDATE_MOVIE_JSP;
	}

	@GetMapping(value = Constant.DELETE_BY_ID_REQUEST)
	private String deleteMovie(@PathVariable("id") int id) {
		movieService.delete(id);
		return Constant.REDIRECT_MOVIE;
	}
}
