package com.web.edu.third.party.service;

import java.util.List;

import com.web.edu.third.party.entity.Category;

public interface CategoryService {
	Boolean createCategory(String name);

	List<Category> getAllCateCourseCategory();
}
