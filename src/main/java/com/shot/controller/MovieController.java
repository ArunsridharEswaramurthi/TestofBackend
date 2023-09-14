package com.shot.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.shot.model.Movie;
import com.shot.service.MovieService;

@CrossOrigin
@RestController
@RequestMapping("/movie")
public class MovieController {

	private MovieService movieService;

	@Autowired
	public MovieController(MovieService movieService) {
		this.movieService = movieService;
	}

	@PostMapping("/add")
	public ResponseEntity<?> adddata(@RequestBody Movie movie) {
	    try {
	        movieService.addData(movie);
	        return ResponseEntity.status(HttpStatus.OK).body(movie);
	    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error adding data: " + e.getMessage());
	    }
	}

	@GetMapping("/retrieveall")
	public ResponseEntity<List<Movie>> getAllMovieDetails() {
		List<Movie> movies = movieService.getAllMovies();
		return new ResponseEntity<>(movies, HttpStatus.OK);
	}

	@GetMapping("/retrieve/{movieId}")
	public ResponseEntity<Movie> getMovieById(@PathVariable Long movieId) {
		Movie movie = movieService.getById(movieId);
		return new ResponseEntity<Movie>(movie, HttpStatus.OK);
	}
	
	@PutMapping("/update/{movieId}")
	public ResponseEntity<Movie> update(@RequestBody Movie movie, @PathVariable Long movieId) {  
	    Movie put = movieService.update(movie, movieId);
	    return new ResponseEntity<Movie>(put, HttpStatus.OK);
	}


	@DeleteMapping("/delete/{movieId}")
	public ResponseEntity<Void> deleteMovie(@PathVariable Long movieId) {
		movieService.delete(movieId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@GetMapping("/retrieveByMovie/{movieName}")
	public List<Movie> getByMovieName(@PathVariable String movieName) {
		return movieService.getMoviesByMovieName(movieName);
	}
}
