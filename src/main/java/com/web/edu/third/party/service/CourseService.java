package com.web.edu.third.party.service;

import java.util.List;

import com.web.edu.third.party.requestDTO.CourseEditRequestDTO;
import com.web.edu.third.party.requestDTO.CourseRequestDTO;
import com.web.edu.third.party.responseDTO.CourseResponseDTO;

public interface CourseService {
	Boolean createCoures(CourseRequestDTO dto);

	Boolean editCourse(CourseEditRequestDTO dto);

	Boolean deleteCourse(int id);

	List<CourseResponseDTO> searchCourse(String courseName);

	List<CourseResponseDTO> getAllCourse();
}
