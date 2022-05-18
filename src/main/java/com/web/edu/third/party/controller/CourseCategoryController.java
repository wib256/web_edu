package com.web.edu.third.party.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.edu.third.party.entity.CourseCategory;
import com.web.edu.third.party.service.CourseCategoryService;

@RestController
@RequestMapping("/api/courseCategory")
public class CourseCategoryController {
	@Autowired
	CourseCategoryService courseCategoryService;

	@PostMapping("/category/{name}")
	public Boolean createCourseCategory(@PathVariable String name) {
		return courseCategoryService.createCategory(name);
	}

	@GetMapping("/category")
	public List<CourseCategory> getAllCategory() {
		return courseCategoryService.getAllCateCourseCategory();
	}
}
