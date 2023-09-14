package com.shot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shot.model.SongsAndScene;

@Repository
public interface ISongsAndSceneRepository extends JpaRepository<SongsAndScene, Long> {

	List<SongsAndScene> findByMovieId(Long movieId);

	List<SongsAndScene> findByLocationId(Long locationId);

}
