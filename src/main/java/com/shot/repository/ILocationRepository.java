package com.shot.repository;

import com.shot.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ILocationRepository extends JpaRepository<Location, Long> {

	public List<Location> findByLocationName(String locationName);

}
