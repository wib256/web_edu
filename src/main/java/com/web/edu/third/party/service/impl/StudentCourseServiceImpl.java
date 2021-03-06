package com.web.edu.third.party.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.edu.third.party.entity.StudentCourse;
import com.web.edu.third.party.repository.StudentCourseRepository;
import com.web.edu.third.party.requestDTO.StudentCourseRequestDTO;
import com.web.edu.third.party.responseDTO.StudentCourseResponseDTO;
import com.web.edu.third.party.service.StudentCourseService;

@Service
public class StudentCourseServiceImpl implements StudentCourseService {

	@Autowired
	private StudentCourseRepository studentCourseRepository;

	@Override
	public Boolean createStudentCourse(StudentCourseRequestDTO dto) {
		try {
			if (studentCourseRepository.countByStudentUsernameAndCourseLevelId(dto.getStudentName(), dto.getCourseLevelId()) > 0) {
				return false;
			}
			StudentCourse studentCourse = new StudentCourse();
			studentCourse.setCourseLevelId(dto.getCourseLevelId());
			studentCourse.setStudentName(dto.getStudentName());
			studentCourseRepository.save(studentCourse);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<StudentCourseResponseDTO> getStudentCourseByStudentName(String studentName) {
		List<StudentCourse> studentCourses = new ArrayList<StudentCourse>();
		List<StudentCourseResponseDTO> studentCourseResponseDTOs = new ArrayList<StudentCourseResponseDTO>();
		studentCourses = studentCourseRepository.findByStudentUsernameIgnoreCase(studentName);
		if (!studentCourses.isEmpty()) {
			for (StudentCourse studentCourse : studentCourses) {
				StudentCourseResponseDTO studentCourseResponseDTO = new StudentCourseResponseDTO();
				studentCourseResponseDTO.setId(studentCourse.getId());
				studentCourseResponseDTO.setCourseLevelId(studentCourse.getCourseLevelId());
				studentCourseResponseDTO.setStudentName(studentCourse.getStudentName());
				studentCourseResponseDTO.setCourseLevelName(studentCourse.getCourseLevel().getName());
				studentCourseResponseDTOs.add(studentCourseResponseDTO);
			}
		}
		return studentCourseResponseDTOs;
	}

}
