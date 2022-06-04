package com.web.edu.third.party.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.edu.third.party.requestDTO.HomeworkResultDRequestDTO;
import com.web.edu.third.party.responseDTO.HomeworkResultDResponseDTO;
import com.web.edu.third.party.service.HomeworkResultService;

@RestController
@RequestMapping("/api/homeworkResult")
public class HomeworkResultController {
	@Autowired
	private HomeworkResultService homeworkResultService;

	@PostMapping("/createHomeworkResult")
	public HomeworkResultDResponseDTO createHomeworkResult(@RequestBody HomeworkResultDRequestDTO dto) {
		return homeworkResultService.createHomeworkResult(dto);
	}

	@GetMapping("/getHomeworkResultById/{homeworkId}")
	public List<HomeworkResultDResponseDTO> getHomeworkResultById(@PathVariable int homeworkId) {
		return homeworkResultService.getHomeworkResultByHomeworkId(homeworkId);
	}

	@GetMapping("/getHomeworkResultByHomeworkResultId/{id}")
	public HomeworkResultDResponseDTO getHomeworkResultByHomeworkResultId(@PathVariable int id) {
		return homeworkResultService.getHomeworkResultByHomeworkResultId(id);
	}

	@GetMapping("/getHomeworkResultByHomeworkUsername/{username}")
	public List<HomeworkResultDResponseDTO> getHomeworkResultByHomeworkResultId(@PathVariable String username) {
		return homeworkResultService.getHomeworkResultByStudentUsername(username);
	}
}
