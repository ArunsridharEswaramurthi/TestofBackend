package com.shot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shot.model.SongsAndScene;
import com.shot.repository.ISongsAndSceneRepository;

@Service
public class SongsAndSceneService implements ISongsAndSceneService {

	@Autowired
	private ISongsAndSceneRepository songsAndSceneRepository;

	@Override
	public SongsAndScene save(SongsAndScene songsAndScene) {
		return songsAndSceneRepository.save(songsAndScene);
	}

	@Override
	public SongsAndScene update(Long id, SongsAndScene songsAndScenes) {
		songsAndScenes.setId(id);
		return songsAndSceneRepository.save(songsAndScenes);
	}

	@Override
	public void delete(Long id) {
		songsAndSceneRepository.deleteById(id);
	}

	@Override
	public SongsAndScene getById(Long id) {
		return songsAndSceneRepository.findById(id).orElse(null);
	}

	@Override
	public List<SongsAndScene> getAllSongsAndScenes() {
		return songsAndSceneRepository.findAll();
	}

	@Override
	public List<SongsAndScene> getSongsAndScenesByMovieId(Long movieId) {
		return songsAndSceneRepository.findByMovieId(movieId);
	}
}
