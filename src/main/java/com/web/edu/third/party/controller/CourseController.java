package com.web.edu.third.party.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.edu.third.party.requestDTO.CourseEditRequestDTO;
import com.web.edu.third.party.requestDTO.CourseRequestDTO;
import com.web.edu.third.party.responseDTO.CourseResponseDTO;
import com.web.edu.third.party.service.CourseService;

@RestController
@RequestMapping("/api/course")
public class CourseController {
	@Autowired
	private CourseService courseService;

	@GetMapping("/getAllCourse")
	public List<CourseResponseDTO> getAllCourse() {
		return courseService.getAllCourse();
	}

	@GetMapping("/getCourseByName/{courseName}")
	public List<CourseResponseDTO> getCourseByName(@PathVariable String courseName) {
		return courseService.searchCourse(courseName);
	}

	@PostMapping("/createCourse")
	public Boolean createCourse(@RequestBody CourseRequestDTO dto) {
		return courseService.createCoures(dto);
	}

	@PutMapping("/editCourse")
	public Boolean editCourse(@RequestBody CourseEditRequestDTO dto) {
		return courseService.editCourse(dto);
	}

	@DeleteMapping("/deleteCourse/{id}")
	public Boolean deleteCourse(@PathVariable int id) {
		return courseService.deleteCourse(id);
	}
}
