package com.shot.service;

import java.util.List;
import com.shot.model.Movie;

public interface IMovieService {

	List<Movie> getAllMovies();

	Movie getById(Long movieId);

	void delete(Long movieId);

	List<Movie> getMoviesByMovieName(String movieName);
}
