package com.web.edu.third.party.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.edu.third.party.entity.Course;
import com.web.edu.third.party.repository.CourseRepository;
import com.web.edu.third.party.requestDTO.CourseRequestDTO;
import com.web.edu.third.party.service.CourseCategoryService;
import com.web.edu.third.party.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseRepository courseRepository;

	@Autowired
	private CourseCategoryService courseCategoryService;

	@Override
	public Boolean createCoures(CourseRequestDTO dto) {
		if (courseRepository.countByName(dto.getName()) == 0) {
			Course course = new Course();
			course.setName(dto.getName());
			course.setDescription(dto.getDescription());
			Course savedCourse = courseRepository.save(course);
			if (dto.getCategoties().size() > 0) {
				for (int i = 0; i < dto.getCategoties().size(); i++) {
					courseCategoryService.saveCourseCategory(savedCourse.getId(), dto.getCategoties().get(i));
				}
			}
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List<Course> searchCourse(String courseName) {
		List<Course> courses = new ArrayList<Course>();
		courses = courseRepository.getCoursesByName(courseName);
		return courses;
	}

	@Override
	public List<Course> getAllCourse() {
		List<Course> courses = new ArrayList<Course>();
		courses = courseRepository.findAll();
		return courses;
	}

}
