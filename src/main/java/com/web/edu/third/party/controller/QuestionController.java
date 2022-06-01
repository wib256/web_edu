package com.web.edu.third.party.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.edu.third.party.requestDTO.QuestionRequestDTO;
import com.web.edu.third.party.responseDTO.QuestionResponseDTO;
import com.web.edu.third.party.service.QuestionService;

@RestController
@RequestMapping("/api/question")
public class QuestionController {
	@Autowired
	private QuestionService questionService;

	@PostMapping("/createQuestion")
	public Boolean createQuestion(@RequestBody QuestionRequestDTO dto) {
		return questionService.createQuestion(dto);
	}

	@PostMapping("/createListQuestion")
	public Boolean createListQuestion(@RequestBody List<QuestionRequestDTO> dtos) {
		return questionService.createListAQuestion(dtos);
	}

	@GetMapping("/getQuestionByHomeworkId/{homeworkId}")
	public List<QuestionResponseDTO> getQuestionByHomeworkId(@PathVariable int homeworkId) {
		return questionService.getQuestionsByHomeworkId(homeworkId);
	}

	@GetMapping("/checkListQuestionsByHomeworkId/{homeworkId}")
	public List<QuestionResponseDTO> checkListQuestionsByHomeworkId(@PathVariable int homeworkId) {
		return questionService.checkListQuestionsByHomeworkId(homeworkId);
	}
}
