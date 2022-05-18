package com.web.edu.third.party.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.web.edu.third.party.constant.Constant;
import com.web.edu.third.party.entity.CourseCategory;
import com.web.edu.third.party.repository.CourseCategoryRepository;
import com.web.edu.third.party.service.CourseCategoryService;

@Service
public class CourseCategoryImpl implements CourseCategoryService {

	@Autowired
	CourseCategoryRepository courseCategoryRepository;

	@Override
	public Boolean createCategory(String name) {
		if (courseCategoryRepository.countByName(name) == 0) {
			CourseCategory courseCategory = new CourseCategory();
			courseCategory.setName(name);
			courseCategoryRepository.save(courseCategory);
			return true;
		} else {
			throw new ResponseStatusException(HttpStatus.CONFLICT, Constant.ERROR_COURSE_CATEGORY);
		}
	}

	@Override
	public List<CourseCategory> getAllCateCourseCategory() {
		List<CourseCategory> list = new ArrayList<CourseCategory>();
		list = courseCategoryRepository.findAll();
		return list;
	}

}
