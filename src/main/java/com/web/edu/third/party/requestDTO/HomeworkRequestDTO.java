package com.web.edu.third.party.requestDTO;

public class HomeworkRequestDTO {
	private Integer courseLevelId;
	private String teacherUsername;
	private String name;
	private String description;

	public Integer getCourseLevelId() {
		return courseLevelId;
	}

	public void setCourseLevelId(Integer courseLevelId) {
		this.courseLevelId = courseLevelId;
	}

	public String getTeacherUsername() {
		return teacherUsername;
	}

	public void setTeacherUsername(String teacherUsername) {
		this.teacherUsername = teacherUsername;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
