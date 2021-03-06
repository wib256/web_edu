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
@Table(name = "Student_course")
public class StudentCourse {
	@Id
	@Column(name = "Id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "Course_level_id")
	private Integer courseLevelId;

	@Column(name = "Student_username")
	private String studentName;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Course_level_id", insertable = false, updatable = false)
	private CourseLevel courseLevel;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Student_username", insertable = false, updatable = false)
	private Student student;

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

	public CourseLevel getCourseLevel() {
		return courseLevel;
	}

	public void setCourseLevel(CourseLevel courseLevel) {
		this.courseLevel = courseLevel;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}
