package com.cignex.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cignex.entities.Movie;
import com.cignex.repositories.MovieRepository;

@Service("movieService")
public class MovieService {
	@Autowired
	private MovieRepository movieRepository;
	
	public void save(Movie movie) {
		movieRepository.save(movie);
	}
	
	public List<Movie> getAllMovie(){
		List<Movie> list=movieRepository.findAll();
		return list;
	}
	
	public Movie getMovieById(int id) {
		Movie movie=movieRepository.findById(id);
		return movie;
	}
	
	public void delete(int id) {
		Movie movie=movieRepository.findById(id);
		movieRepository.delete(movie);
	}
}
