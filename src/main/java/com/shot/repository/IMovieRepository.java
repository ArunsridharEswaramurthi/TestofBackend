package com.shot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.shot.model.Movie;

@Repository
public interface IMovieRepository extends JpaRepository<Movie, Long> {

	public List<Movie> findByMovieName(String movieName);

}
