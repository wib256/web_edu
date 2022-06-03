package com.web.edu.third.party.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "homework")
public class Homework {
	@Id
	@Column(name = "Id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "Course_level_id")
	private Integer courseLevelId;

	@Column(name = "Teacher_Username")
	private String teacherUsername;

	@Column(name = "Name")
	private String name;

	@Column(name = "Description")
	private String description;

	@OneToMany(mappedBy = "homework")
	private List<Question> questions;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Course_level_id", insertable = false, updatable = false)
	private CourseLevel courseLevel;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Teacher_Username", insertable = false, updatable = false)
	private Teacher teacher;

	@OneToMany(mappedBy = "homework")
	private List<HomeworkResult> homeworkResults;

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

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public CourseLevel getCourseLevel() {
		return courseLevel;
	}

	public void setCourseLevel(CourseLevel courseLevel) {
		this.courseLevel = courseLevel;
	}

	public List<HomeworkResult> getHomeworkResults() {
		return homeworkResults;
	}

	public void setHomeworkResults(List<HomeworkResult> homeworkResults) {
		this.homeworkResults = homeworkResults;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

}
