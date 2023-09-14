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

import com.shot.model.SongsAndScene;
import com.shot.service.ISongsAndSceneService;

@CrossOrigin
@RestController
@RequestMapping("/songsandscene")
public class SongsAndSceneController {

	@Autowired
	private ISongsAndSceneService songsAndSceneService;

	@PostMapping("/add")
	public ResponseEntity<SongsAndScene> createSongsAndScene(@RequestBody SongsAndScene songsAndScene) {
		SongsAndScene createdSongsAndScene = songsAndSceneService.save(songsAndScene);
		return new ResponseEntity<>(createdSongsAndScene, HttpStatus.CREATED);
	}

	@GetMapping("/retrieve/{id}")
	public ResponseEntity<SongsAndScene> getSongsAndSceneById(@PathVariable Long id) {
		SongsAndScene optionalSongsAndScene = songsAndSceneService.getById(id);
		return new ResponseEntity<>(optionalSongsAndScene, HttpStatus.OK);
	}

	@GetMapping("/retrieveall")
	public ResponseEntity<List<SongsAndScene>> getAllSongsAndScenes() {
		List<SongsAndScene> songsAndScenes = songsAndSceneService.getAllSongsAndScenes();
		return new ResponseEntity<>(songsAndScenes, HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<SongsAndScene> updateSongsAndScene(@PathVariable Long id,
			@RequestBody SongsAndScene songsAndScene) {
		SongsAndScene songsAndSceneObj = songsAndSceneService.update(id, songsAndScene);
		return new ResponseEntity<>(songsAndSceneObj, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteSongsAndScene(@PathVariable Long id) {
		songsAndSceneService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@GetMapping("/bymovie/{movieId}")
	public ResponseEntity<List<SongsAndScene>> getSongsAndScenesByMovieId(@PathVariable Long movieId) {
		List<SongsAndScene> songsAndScenes = songsAndSceneService.getSongsAndScenesByMovieId(movieId);
		return new ResponseEntity<>(songsAndScenes, HttpStatus.OK);
	}
}
