package com.shot.payload;

import jakarta.persistence.Id;

public class LocationFile {

	@Id
	private Long locationId;
	private String fileName;
	private String message;

	public LocationFile(Long locationId, String fileName, String message) {
		this.locationId = locationId;
		this.fileName = fileName;
		this.message = message;
	}

	public Long getLocationId() {
		return locationId;
	}

	public void setLocationId(Long locationId) {
		this.locationId = locationId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "LocationFile [locationId=" + locationId + ", fileName=" + fileName + ", message=" + message + "]";
	}
	
}
