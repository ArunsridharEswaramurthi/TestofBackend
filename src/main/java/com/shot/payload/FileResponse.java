package com.shot.payload;

import jakarta.persistence.Id;

public class FileResponse {

	@Id
	private Long movieId;
	private String fileName;
	private String message;

	public FileResponse(Long movieId, String fileName, String message) {
		this.movieId = movieId;
		this.fileName = fileName;
		this.message = message;
	}

	public Long getMovieId() {
		return movieId;
	}

	public void setMovieId(Long movieId) {
		this.movieId = movieId;
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
		return "FileResponse [movieId=" + movieId + ", fileName=" + fileName + ", message=" + message + "]";
	}
}
