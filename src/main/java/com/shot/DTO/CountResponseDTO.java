package com.shot.DTO;

public class CountResponseDTO {

	private Long movieCount;
	private Long locationCount;
	private Long songsAndScenesCount;

	public Long getMovieCount() {
		return movieCount;
	}

	public void setMovieCount(Long movieCount) {
		this.movieCount = movieCount;
	}

	public Long getLocationCount() {
		return locationCount;
	}

	public void setLocationCount(Long locationCount) {
		this.locationCount = locationCount;
	}

	public Long getSongsAndScenesCount() {
		return songsAndScenesCount;
	}

	public void setSongsAndScenesCount(Long songsAndScenesCount) {
		this.songsAndScenesCount = songsAndScenesCount;
	}

}
