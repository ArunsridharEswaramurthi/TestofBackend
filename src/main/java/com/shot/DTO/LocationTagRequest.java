package com.shot.DTO;

import java.util.List;

import com.shot.model.Location;
import com.shot.model.Tag;

public class LocationTagRequest {
	  private Location location;
	    private List<Tag> tags;

	    // Getters and setters
	    public Location getLocation() {
	        return location;
	    }

	    public void setLocation(Location location) {
	        this.location = location;
	    }

	    public List<Tag> getTags() {
	        return tags;
	    }

	    public void setTags(List<Tag> tags) {
	        this.tags = tags;
	    }
}
