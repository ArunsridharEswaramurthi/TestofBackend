package com.shot.service;

import java.util.List;

import com.shot.model.SongsAndScene;

public interface ISongsAndSceneService {
	
    SongsAndScene save(SongsAndScene songsAndScene);
    
    SongsAndScene update(Long ssId, SongsAndScene songsAndScene);
    
    void delete(Long id);
    
    SongsAndScene getById(Long id);
    
    List<SongsAndScene> getAllSongsAndScenes();
    
    List<SongsAndScene> getSongsAndScenesByMovieId(Long movieId);

}
