 package com.shot.model;

import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

@Entity
@Table(name = "Movie")
public class Movie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long movieId;
	private String movieName;
	private  String releasedYear;
	private String starring;
	private String music;
	private String direction;
	private String description;
	private String image;
	private String wikiLink;
	private String language;
	private LocalDate lastUpdatedDate;

	public Movie() {

	}

	public Movie( String movieName, String releasedYear, String starring,String music,
			String direction, String description, String image, String wikiLink,String language) {
		this.movieName = movieName;
		this.releasedYear = releasedYear;
		this.starring = starring;
		this.music = music;
		this.direction = direction;
		this.description = description;
		this.image = image;
		this.wikiLink = wikiLink;
		this.language = language;
	}

	public Long getMovieId() {
		return movieId;
	}

	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getReleasedYear() {
		return releasedYear;
	}

	public void setReleasedYear(String releasedYear) {
		this.releasedYear = releasedYear;
	}

	public String getStarring() {
		return starring;
	}

	public void setStarring(String starring) {
		this.starring = starring;
	}

	public String getMusic() {
		return music;
	}

	public void setMusic(String music) {
		this.music = music;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getWikiLink() {
		return wikiLink;
	}

	public void setWikiLink(String wikiLink) {
		this.wikiLink = wikiLink;
	}
	
	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public LocalDate getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedDate(LocalDate lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	@PrePersist
	public void setLastUpdatedDateOnCreate() {
		this.lastUpdatedDate = LocalDate.now();
	}

	@PreUpdate
	public void setLastUpdatedDateOnUpdate() {
		this.lastUpdatedDate = LocalDate.now();
	}

	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", movieName=" + movieName + ", releasedYear=" + releasedYear
				+ ", starring=" + starring + ", music=" + music + ", direction=" + direction + ", description="
				+ description + ", image=" + image + ", wikiLink=" + wikiLink + ", language=" + language
				+ ", lastUpdatedDate=" + lastUpdatedDate + "]";
	}
	
}
