package com.web.edu.third.party.service;

import java.util.List;

import com.web.edu.third.party.requestDTO.CourseRequestDTO;
import com.web.edu.third.party.responseDTO.CourseResponseDTO;

public interface CourseService {
	Boolean createCoures(CourseRequestDTO dto);

	List<CourseResponseDTO> searchCourse(String courseName);

	List<CourseResponseDTO> getAllCourse();
}
