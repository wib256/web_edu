package com.web.edu.third.party.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.edu.third.party.entity.CourseCategory;
import com.web.edu.third.party.repository.CourseCategoryRepository;
import com.web.edu.third.party.service.CourseCategoryService;

@Service
public class CourseCategoryServiceImpl implements CourseCategoryService {

	@Autowired
	private CourseCategoryRepository courseCategoryRepository;

	@Override
	public Boolean saveCourseCategory(int courseId, int categoryId) {
		try {
			CourseCategory courseCategory = new CourseCategory();
			courseCategory.setCategoryId(categoryId);
			courseCategory.setCourseId(courseId);
			courseCategoryRepository.save(courseCategory);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
