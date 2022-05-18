package com.web.edu.third.party.service;

import java.util.List;

import com.web.edu.third.party.entity.CourseCategory;

public interface CourseCategoryService {
	Boolean createCategory(String name);

	List<CourseCategory> getAllCateCourseCategory();
}
