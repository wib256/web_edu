package com.web.edu.third.party.requestDTO;

public class VideoRequestDTO {
	private Integer id;
	private Integer courseLevelId;
	private String name;
	private String urlYoutube;
	private String urlFisebase;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCourseLevelId() {
		return courseLevelId;
	}

	public void setCourseLevelId(Integer courseLevelId) {
		this.courseLevelId = courseLevelId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrlYoutube() {
		return urlYoutube;
	}

	public void setUrlYoutube(String urlYoutube) {
		this.urlYoutube = urlYoutube;
	}

	public String getUrlFisebase() {
		return urlFisebase;
	}

	public void setUrlFisebase(String urlFisebase) {
		this.urlFisebase = urlFisebase;
	}

}
