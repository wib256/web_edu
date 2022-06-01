package com.web.edu.third.party.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "course")
public class Course {
	@Id
	@Column(name = "Id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "Name")
	private String name;

	@Column(name = "Description")
	private String description;

	@OneToMany(mappedBy = "course")
	private List<CourseCategory> courseCategories;

	@OneToMany(mappedBy = "course")
	private List<Homework> homeworks;

	@OneToMany(mappedBy = "course")
	private List<CourseLevel> courseLevels;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public List<CourseCategory> getCourseCategories() {
		return courseCategories;
	}

	public void setCourseCategories(List<CourseCategory> courseCategories) {
		this.courseCategories = courseCategories;
	}

	public List<Homework> getHomeworks() {
		return homeworks;
	}

	public void setHomeworks(List<Homework> homeworks) {
		this.homeworks = homeworks;
	}

	public List<CourseLevel> getCourseLevels() {
		return courseLevels;
	}

	public void setCourseLevels(List<CourseLevel> courseLevels) {
		this.courseLevels = courseLevels;
	}

}
