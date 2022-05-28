package com.web.edu.third.party.service;

import java.util.List;

import com.web.edu.third.party.requestDTO.StudentCourseRequestDTO;
import com.web.edu.third.party.responseDTO.StudentCourseResponseDTO;

public interface StudentCourseService {
	Boolean createStudentCourse(StudentCourseRequestDTO dto);

	List<StudentCourseResponseDTO> getStudentCourseByStudentName(String studentName);
}
