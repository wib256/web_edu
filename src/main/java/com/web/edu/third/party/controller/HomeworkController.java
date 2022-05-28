package com.web.edu.third.party.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.edu.third.party.requestDTO.HomeworkRequestDTO;
import com.web.edu.third.party.responseDTO.HomeworkResponseDTO;
import com.web.edu.third.party.service.HomeworkService;

@RestController
@RequestMapping("/api/homework")
public class HomeworkController {
	@Autowired
	private HomeworkService homeworkService;

	@PostMapping("/createHomework")
	public boolean createHomework(@RequestBody HomeworkRequestDTO dto) {
		return homeworkService.craeteHomework(dto);
	}

	@GetMapping("/getHomeworkByCourseId/{courseId}")
	public List<HomeworkResponseDTO> getHomeworkByCourseId(@PathVariable int courseId) {
		return homeworkService.getHomeworkByCourseId(courseId);
	}
}
