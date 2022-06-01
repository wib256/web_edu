package com.web.edu.third.party.service;

import java.util.List;

import com.web.edu.third.party.requestDTO.StudentAnswerRequestDTO;

public interface StudentAnswerService {
	Boolean saveAnswers(List<StudentAnswerRequestDTO> dtos);
}
