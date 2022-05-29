package com.web.edu.third.party.responseDTO;

import java.util.List;

public class CourseResponseDTO {
	private Integer id;
	private String name;
	private String description;
	List<String> categoryName;
	private List<Integer> courseCategoriesId;

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

	public List<String> getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(List<String> categoryName) {
		this.categoryName = categoryName;
	}

	public List<Integer> getCourseCategoriesId() {
		return courseCategoriesId;
	}

	public void setCourseCategoriesId(List<Integer> courseCategoriesId) {
		this.courseCategoriesId = courseCategoriesId;
	}

}
