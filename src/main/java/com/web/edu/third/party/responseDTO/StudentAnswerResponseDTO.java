package com.web.edu.third.party.responseDTO;

public class StudentAnswerResponseDTO {
	private Integer id;
	private Integer homeworkResultId;
	private String answer;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getHomeworkResultId() {
		return homeworkResultId;
	}

	public void setHomeworkResultId(Integer homeworkResultId) {
		this.homeworkResultId = homeworkResultId;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

}
