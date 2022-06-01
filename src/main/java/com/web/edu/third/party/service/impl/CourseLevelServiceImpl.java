package com.web.edu.third.party.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.edu.third.party.entity.CourseLevel;
import com.web.edu.third.party.repository.CourseLevelRepository;
import com.web.edu.third.party.requestDTO.CourseLevelRequestDTO;
import com.web.edu.third.party.service.CourseLevelService;

@Service
public class CourseLevelServiceImpl implements CourseLevelService {
	@Autowired
	private CourseLevelRepository courseLevelRepository;

	@Override
	public Boolean createCourseLevel(CourseLevelRequestDTO dto) {
		try {
			CourseLevel courseLevel = new CourseLevel();
			courseLevel.setCourseId(dto.getCourseId());
			courseLevel.setDescription(dto.getDescription());
			courseLevel.setName(dto.getName());
			courseLevel.setPrice(dto.getPrice());
			courseLevelRepository.save(courseLevel);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

}
