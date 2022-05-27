package com.web.edu.third.party.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.edu.third.party.entity.Category;
import com.web.edu.third.party.service.CategoryService;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
	@Autowired
	CategoryService courseCategoryService;

	@PostMapping("/{name}")
	public Boolean createCourseCategory(@PathVariable String name) {
		return courseCategoryService.createCategory(name);
	}

	@GetMapping("/getAllCategory")
	public List<Category> getAllCategory() {
		return courseCategoryService.getAllCateCourseCategory();
	}
}
