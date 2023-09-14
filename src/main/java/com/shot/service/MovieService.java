package com.shot.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shot.model.Movie;
import com.shot.repository.IMovieRepository;

@Service
public class MovieService implements IMovieService {

	@Autowired
	private IMovieRepository movieRepository;

	@Autowired
	public MovieService(IMovieRepository movieRepository) {
		this.movieRepository = movieRepository;
	}

	public void addData(Movie movie) {
		 movieRepository.save(movie);
	}

	@Override
	public List<Movie> getAllMovies() {
		return movieRepository.findAll();
	}

	@Override
	public Movie getById(Long movieId) {
		return movieRepository.findById(movieId).get();
	}

	@Override
	public void delete(Long movieId) {
		movieRepository.deleteById(movieId);
	}
	
	public Movie update(Movie movie, long movieId) {
		Movie updatedata= movieRepository.findById(movieId).get();
		updatedata.setMovieName(movie.getMovieName());
		updatedata.setReleasedYear(movie.getReleasedYear());
		updatedata.setStarring(movie.getStarring());
		updatedata.setMusic(movie.getMusic());
		updatedata.setDirection(movie.getDirection());
		updatedata.setDescription(movie.getDescription());
		updatedata.setImage(movie.getImage());
		updatedata.setWikiLink(movie.getWikiLink());
		updatedata.setLanguage(movie.getLanguage());
		return movieRepository.save(updatedata);

		}

	@Override
	public List<Movie> getMoviesByMovieName(String movieName) {
		return movieRepository.findByMovieName(movieName);
	}
}
