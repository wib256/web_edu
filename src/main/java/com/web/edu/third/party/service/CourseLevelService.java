package com.web.edu.third.party.service;

import java.util.List;

import com.web.edu.third.party.requestDTO.CourseLevelRequestDTO;
import com.web.edu.third.party.responseDTO.CourseLevelResponseDTO;

public interface CourseLevelService {
	Boolean createCourseLevel(CourseLevelRequestDTO dto);

	List<CourseLevelResponseDTO> getCourseLevelByCourseId(int courseId);

	Boolean editCourseLevel(CourseLevelRequestDTO dto);

	Boolean deleteCourseLevel(int id);
}
