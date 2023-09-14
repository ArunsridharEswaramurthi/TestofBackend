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

import com.shot.model.Location;
import com.shot.model.Movie;
import com.shot.service.LocationService;

@RestController
@RequestMapping("/location")
@CrossOrigin
public class LocationController {
	private LocationService locationService;

	@Autowired
	public LocationController(LocationService locationService) {
		this.locationService = locationService;
	}

	
	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody  Location location) {
	    try {
	    	locationService.add(location);
	        return ResponseEntity.status(HttpStatus.OK).body(location);
	    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error adding data: " + e.getMessage());
	    }
	}


	@GetMapping("/get/{id}")
	public Location getLocationDetails(@PathVariable("id") Long id) {
		return locationService.getById(id);
	}

	@GetMapping("/getList")
	public ResponseEntity<List<Location>> getAllLocations() {
		List<Location> allLocations = locationService.getAllLocations();
		return new ResponseEntity<>(allLocations, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable("id") Long id) {
		locationService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	 @PutMapping("/update/{id}")
	 public ResponseEntity<Location> update(@RequestBody Location location, @PathVariable Long id) {  
		    Location put = locationService.update(location, id);
		    return new ResponseEntity<Location>(put, HttpStatus.OK);
		}
	


	@GetMapping("/findByName/{locationName}")
	public ResponseEntity<List<Location>> findByLocationName(@PathVariable("locationName") String locationName) {
		List<Location> locations = locationService.getLocationsByLocationName(locationName);
		if (!locations.isEmpty()) {
			return new ResponseEntity<>(locations, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/getMoviesByLocation/{id}")
	public ResponseEntity<List<Movie>> getMoviesByLocation(@PathVariable("id") Long id) {
		List<Movie> movies = locationService.getMoviesByLocation(id);
		if (!movies.isEmpty()) {
			return new ResponseEntity<>(movies, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}


}
