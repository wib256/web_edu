package com.web.edu.third.party.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.edu.third.party.entity.CourseLevel;
import com.web.edu.third.party.repository.CourseLevelRepository;
import com.web.edu.third.party.requestDTO.CourseLevelRequestDTO;
import com.web.edu.third.party.responseDTO.CourseLevelResponseDTO;
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

	@Override
	public List<CourseLevelResponseDTO> getCourseLevelByCourseId(int courseId) {
		List<CourseLevel> courseLevels = courseLevelRepository.findByCourseId(courseId);
		List<CourseLevelResponseDTO> courseLevelResponseDTOs = new ArrayList<CourseLevelResponseDTO>();
		if (!courseLevels.isEmpty()) {
			for (CourseLevel courseLevel: courseLevels) {
				CourseLevelResponseDTO courseLevelResponseDTO = new CourseLevelResponseDTO();
				courseLevelResponseDTO.setCourseId(courseLevel.getCourseId());
				courseLevelResponseDTO.setDescription(courseLevel.getDescription());
				courseLevelResponseDTO.setId(courseLevel.getId());
				courseLevelResponseDTO.setName(courseLevel.getName());
				courseLevelResponseDTO.setPrice(courseLevel.getPrice());
				courseLevelResponseDTOs.add(courseLevelResponseDTO);
			}
		}
		
		return courseLevelResponseDTOs;
	}

}
