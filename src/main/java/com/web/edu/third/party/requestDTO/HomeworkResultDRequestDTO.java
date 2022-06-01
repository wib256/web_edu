package com.web.edu.third.party.requestDTO;

import java.util.List;

public class HomeworkResultDRequestDTO {
	private Integer homeworkId;
	private String studentUsername;
	private List<StudentAnswerRequestDTO> studentAnswerRequestDTOs;

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

	public List<StudentAnswerRequestDTO> getStudentAnswerRequestDTOs() {
		return studentAnswerRequestDTOs;
	}

	public void setStudentAnswerRequestDTOs(List<StudentAnswerRequestDTO> studentAnswerRequestDTOs) {
		this.studentAnswerRequestDTOs = studentAnswerRequestDTOs;
	}

}
