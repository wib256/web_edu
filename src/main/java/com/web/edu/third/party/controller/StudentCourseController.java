package com.web.edu.third.party.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.edu.third.party.requestDTO.StudentCourseRequestDTO;
import com.web.edu.third.party.responseDTO.StudentCourseResponseDTO;
import com.web.edu.third.party.service.StudentCourseService;

@RestController
@RequestMapping("/api/studentCourse")
public class StudentCourseController {
	@Autowired
	private StudentCourseService studentCourseService;

	@PostMapping("/createStudentCourse")
	public boolean createStudentCourse(@RequestBody StudentCourseRequestDTO dto) {
		return studentCourseService.createStudentCourse(dto);
	}

	@GetMapping("/getStudentCourseByStudentName/{studentName}")
	public List<StudentCourseResponseDTO> getStudentCourseByStudentName(@PathVariable String studentName) {
		return studentCourseService.getStudentCourseByStudentName(studentName);
	}
}
