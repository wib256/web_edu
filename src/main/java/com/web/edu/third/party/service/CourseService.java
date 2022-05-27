package com.web.edu.third.party.service;

import java.util.List;

import com.web.edu.third.party.entity.Course;
import com.web.edu.third.party.requestDTO.CourseRequestDTO;

public interface CourseService {
	Boolean createCoures(CourseRequestDTO dto);

	List<Course> searchCourse(String courseName);

	List<Course> getAllCourse();
}
