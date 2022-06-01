package com.web.edu.third.party.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "student_answer")
public class StudentAnswer {
	@Id
	@Column(name = "Id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "Homework_result_id")
	private Integer homeworkResultId;

	@Column(name = "Answer")
	private String answer;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Homework_result_id", insertable = false, updatable = false)
	private HomeworkResult homeworkResult;

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

	public HomeworkResult getHomeworkResult() {
		return homeworkResult;
	}

	public void setHomeworkResult(HomeworkResult homeworkResult) {
		this.homeworkResult = homeworkResult;
	}

}
