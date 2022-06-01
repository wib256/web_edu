package com.web.edu.third.party.responseDTO;

public class StudentCourseResponseDTO {
	private Integer id;
	private Integer courseLevelId;
	private String studentName;
	private String courseLevelName;

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

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getCourseLevelName() {
		return courseLevelName;
	}

	public void setCourseLevelName(String courseLevelName) {
		this.courseLevelName = courseLevelName;
	}

}
