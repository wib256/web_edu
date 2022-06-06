package com.web.edu.third.party.requestDTO;

import java.util.List;

public class CourseEditRequestDTO {
	private Integer id;
	private String name;
	private String description;
	private List<Integer> categoties;

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

	public List<Integer> getCategoties() {
		return categoties;
	}

	public void setCategoties(List<Integer> categoties) {
		this.categoties = categoties;
	}
}
