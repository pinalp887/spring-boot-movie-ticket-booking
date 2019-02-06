package com.cignex.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.hibernate.engine.query.spi.ReturnMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.cignex.constant.Constant;
import com.cignex.entities.Movie;
import com.cignex.exception.MovieExceptions;
import com.cignex.services.MovieService;

@Controller
@RequestMapping(value = Constant.MOVIE_CONTROLLER_REQUEST)
@SessionAttributes({ "name", "id", "role","email" })
public class MovieController {
	@Autowired
	private MovieService movieService;

	@GetMapping(value = Constant.HOME_PAGE_REQUEST)
	private ModelAndView home(ModelAndView model) {
		Movie movie = new Movie();
		model.addObject("movie", movie);
		model.setViewName(Constant.MOVIE_REGISTER_JSP);
		return model;
	}

	@GetMapping(value = Constant.REGISTER_REQUEST)
	private ModelAndView register(ModelAndView model) {
		Movie movie = new Movie();
		model.addObject("movie", movie);
		model.setViewName(Constant.MOVIE_REGISTER_JSP);
		return model;
	}

	@PostMapping(value = Constant.SAVE_REQUEST)
	private ModelAndView addMovie(@ModelAttribute Movie movie, ModelAndView model,
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
		model.setViewName(Constant.REDIRECT_MOVIE);
		return model;
	}

	@GetMapping(value = Constant.GET_ALL_DATA_REQUEST)
	private ModelAndView getAllMovie(ModelAndView model) throws IOException, FileNotFoundException {
		List<Movie> list = movieService.getAllMovie();
		model.addObject("list", list);
		String imgString = null;
		for (Movie movie : list) {
			File file = new File(movie.getMoviePath().toString());
			byte[] byteImg = Files.readAllBytes(file.toPath());
			imgString = Base64.encodeBase64String(byteImg);
			movie.setMoviePath(imgString);
		}
		model.setViewName(Constant.LIST_MOVIE_JSP);
		return model;
	}

	@GetMapping(value = Constant.GET_BY_ID_REQUEST)
	private ModelAndView getMovieById(@RequestParam("id") int id, ModelAndView model) {
		Movie movie = movieService.getMovieById(id);
		if (movie == null) {
			throw new MovieExceptions.MovieNotFoundException("requested movie not found with id " + id);
		}
		model.addObject("movie", movie);
		model.setViewName(Constant.UPDATE_MOVIE_JSP);
		return model;
	}

	@GetMapping(value = Constant.DELETE_BY_ID_REQUEST)
	private ModelAndView deleteMovie(@PathVariable("id") int id, ModelAndView model) {
		Movie movie = movieService.getMovieById(id);
		if (movie == null) {
			throw new MovieExceptions.MovieNotFoundException("requested movie not found with id " + id);
		}
		File file = new File(movie.getMoviePath().toString());
		file.delete();
		movieService.delete(id);
		model.setViewName(Constant.REDIRECT_MOVIE);
		return model;
	}
}
