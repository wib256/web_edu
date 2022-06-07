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

import com.web.edu.third.party.requestDTO.CourseLevelRequestDTO;
import com.web.edu.third.party.responseDTO.CourseLevelResponseDTO;
import com.web.edu.third.party.service.CourseLevelService;

@RestController
@RequestMapping("/api/courseLevel")
public class CourseLevelController {
	@Autowired
	private CourseLevelService courseLevelService;

	@PostMapping("/createCourseLevel")
	public Boolean createCourseLevel(@RequestBody CourseLevelRequestDTO dto) {
		return courseLevelService.createCourseLevel(dto);
	}

	@GetMapping("/getCourseLevelByCourseId/{courseId}")
	public List<CourseLevelResponseDTO> getCourseLevelByCourseId(@PathVariable int courseId) {
		return courseLevelService.getCourseLevelByCourseId(courseId);
	}

	@PutMapping("/editCourseLevel")
	public Boolean editCourseLevel(@RequestBody CourseLevelRequestDTO dto) {
		return courseLevelService.editCourseLevel(dto);
	}

	@DeleteMapping("/deleteCourseLevel/{id}")
	public Boolean deleteCourseLevel(@PathVariable int id) {
		return courseLevelService.deleteCourseLevel(id);
	}
}
