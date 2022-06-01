package com.web.edu.third.party.service;

import java.util.List;

import com.web.edu.third.party.requestDTO.QuestionRequestDTO;
import com.web.edu.third.party.responseDTO.QuestionResponseDTO;

public interface QuestionService {
	Boolean createQuestion(QuestionRequestDTO dto);

	Boolean createListAQuestion(List<QuestionRequestDTO> dtos);

	List<QuestionResponseDTO> getQuestionsByHomeworkId(int homeworkId);
	
	List<QuestionResponseDTO> checkListQuestionsByHomeworkId(int homeworkId);
}
