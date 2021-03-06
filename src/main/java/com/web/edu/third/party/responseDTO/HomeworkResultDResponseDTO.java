package com.web.edu.third.party.responseDTO;

import java.util.List;

public class HomeworkResultDResponseDTO {
	private Integer id;
	private Integer homeworkId;
	private String studentUsername;
	private Double point;
	private List<HomeworkResultResponse> homeworkResultResponses;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getHomeworkId() {
		return homeworkId;
	}

	public void setHomeworkId(Integer homeworkId) {
		this.homeworkId = homeworkId;
	}

	public String getStudentUsername() {
		return studentUsername;
	}

	public void setStudentUsername(String studentUsername) {
		this.studentUsername = studentUsername;
	}

	public Double getPoint() {
		return point;
	}

	public void setPoint(Double point) {
		this.point = point;
	}

	public List<HomeworkResultResponse> getHomeworkResultResponses() {
		return homeworkResultResponses;
	}

	public void setHomeworkResultResponses(List<HomeworkResultResponse> homeworkResultResponses) {
		this.homeworkResultResponses = homeworkResultResponses;
	}

}
