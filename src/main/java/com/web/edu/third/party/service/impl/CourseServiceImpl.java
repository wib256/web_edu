package com.web.edu.third.party.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.edu.third.party.entity.Course;
import com.web.edu.third.party.repository.CourseRepository;
import com.web.edu.third.party.requestDTO.CourseRequestDTO;
import com.web.edu.third.party.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService {
	
	@Autowired
	CourseRepository courseRepository;

	@Override
	public Boolean createCoures(CourseRequestDTO dto) {
		if (courseRepository.countByName(dto.getName()) == 0) {
			Course course = new Course();
			course.setName(dto.getName());
			course.setCategory(dto.getCategoryID());
			course.setDescription(dto.getDescription());
			courseRepository.save(course);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List<Course> searchCourse(String courseName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Course> getAllCourse() {
		// TODO Auto-generated method stub
		return null;
	}

}
