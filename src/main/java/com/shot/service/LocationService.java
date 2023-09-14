package com.shot.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.shot.model.Location;
import com.shot.model.Movie;
import com.shot.model.SongsAndScene;
import com.shot.repository.ILocationRepository;
import com.shot.repository.IMovieRepository;
import com.shot.repository.ISongsAndSceneRepository;

@Service
public class LocationService {

	@Autowired
	private ILocationRepository locationRepository;
	@Autowired
	private ISongsAndSceneRepository songsAndSceneRepository;
	@Autowired
	private IMovieRepository movieRepository;

	public Location add(Location location) {
		return locationRepository.save(location);
	}

	public Location update(Location location, Long id) {
		Location locationObj = locationRepository.findById(id).get();
		locationObj.setLocationName(location.getLocationName());
		locationObj.setDescription(location.getDescription());
		locationObj.setType(location.getType());
		locationObj.setState(location.getState());
		locationObj.setCity(location.getCity());
		locationObj.setCountry(location.getCountry());
		locationObj.setLatitude(location.getLatitude());
		locationObj.setLongitude(location.getLongitude());
		locationObj.setLastUpdatedDate(LocalDate.now());
		locationObj.setTags(location.getTags());
		locationObj.setImage(location.getImage());
		return locationRepository.save(locationObj);
	}

	public InputStream getResource(String path, String fileName) throws FileNotFoundException {
		String fullPath = path + File.separator + fileName;
		return new FileInputStream(fullPath);
	}

	public List<Location> getAllLocations() {
		return locationRepository.findAll();
	}

	public Location getById(long id) {
		Optional<Location> locationOptional = locationRepository.findById(id);
		return locationOptional.orElse(null);
	}

	public void delete(long id) {
		locationRepository.deleteById(id);
	}


	public List<Location> getLocationsByLocationName(String locationName) {
		return locationRepository.findByLocationName(locationName);
	}

	public List<Movie> getMoviesByLocation(Long locationId) {
		List<Movie> locations = new ArrayList<>();
		List<SongsAndScene> songsAndScences = songsAndSceneRepository.findByLocationId(locationId);
		for (SongsAndScene songsAndScenesObj : songsAndScences) {
			locations.add(movieRepository.findById(songsAndScenesObj.getMovieId()).get());
		}
		return locations;
	}
}
