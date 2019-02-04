package com.cignex.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.cignex.entities.Movie;
import com.cignex.repositories.MovieRepository;

@Service("movieService")
public class MovieService {
	@Autowired
	private MovieRepository movieRepository;
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void save(Movie movie) {
		movieRepository.save(movie);
	}
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
	public List<Movie> getAllMovie(){
		List<Movie> list=movieRepository.findAll();
		return list;
	}
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public Movie getMovieById(int id) {
		Movie movie=movieRepository.findById(id);
		return movie;
	}
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void delete(int id) {
		Movie movie=movieRepository.findById(id);
		movieRepository.delete(movie);
	}
}
