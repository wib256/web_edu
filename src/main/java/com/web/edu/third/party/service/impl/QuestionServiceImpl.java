package com.web.edu.third.party.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.edu.third.party.entity.Question;
import com.web.edu.third.party.repository.QuestionRepository;
import com.web.edu.third.party.requestDTO.QuestionRequestDTO;
import com.web.edu.third.party.responseDTO.QuestionResponseDTO;
import com.web.edu.third.party.service.QuestionService;

@Service
public class QuestionServiceImpl implements QuestionService {
	@Autowired
	private QuestionRepository questionRepository;

	@Override
	public Boolean createQuestion(QuestionRequestDTO dto) {
		try {
			Question question = new Question();
			question.setHomeworkId(dto.getHomeworkId());
			question.setTopic(dto.getTopic());
			question.setAnswerOne(dto.getAnswerOne());
			question.setAnswerTwo(dto.getAnswerTwo());
			question.setAnswerThree(dto.getAnswerThree());
			question.setAnswerFour(dto.getAnswerFour());
			question.setCorrectAnswer(dto.getCorrectAnswer());
			questionRepository.save(question);
			return true;
		} catch (Exception e) {
			return false;// TODO: handle exception
		}
	}

	@Override
	public Boolean createListAQuestion(List<QuestionRequestDTO> dtos) {
		List<Question> questions = new ArrayList<Question>();
		try {
			if (!dtos.isEmpty()) {
				for (QuestionRequestDTO questionRequestDTO : dtos) {
					Question question = new Question();
					question.setHomeworkId(questionRequestDTO.getHomeworkId());
					question.setTopic(questionRequestDTO.getTopic());
					question.setAnswerOne(questionRequestDTO.getAnswerOne());
					question.setAnswerTwo(questionRequestDTO.getAnswerTwo());
					question.setAnswerThree(questionRequestDTO.getAnswerThree());
					question.setAnswerFour(questionRequestDTO.getAnswerFour());
					question.setCorrectAnswer(questionRequestDTO.getCorrectAnswer());
					questions.add(question);
				}
				questionRepository.saveAll(questions);
				return true;
			}
		} catch (Exception e) {
			return false;
		}
		return null;
	}

	@Override
	public List<QuestionResponseDTO> getQuestionsByHomeworkId(int homeworkId) {
		List<Question> questions = new ArrayList<Question>();
		List<QuestionResponseDTO> questionResponseDTOs = new ArrayList<QuestionResponseDTO>();
		questions = questionRepository.findByHomeworkId(homeworkId);
		if (!questions.isEmpty()) {
			for (Question question : questions) {
				QuestionResponseDTO questionResponseDTO = new QuestionResponseDTO();
				questionResponseDTO.setId(question.getId());
				questionResponseDTO.setHomeworkId(question.getHomeworkId());
				questionResponseDTO.setTopic(question.getTopic());
				questionResponseDTO.setAnswerOne(question.getAnswerOne());
				questionResponseDTO.setAnswerTwo(question.getAnswerTwo());
				questionResponseDTO.setAnswerThree(question.getAnswerThree());
				questionResponseDTO.setAnswerFour(question.getAnswerFour());
				questionResponseDTOs.add(questionResponseDTO);
			}
		}
		return questionResponseDTOs;
	}

	@Override
	public List<QuestionResponseDTO> checkListQuestionsByHomeworkId(int homeworkId) {
		List<Question> questions = new ArrayList<Question>();
		List<QuestionResponseDTO> questionResponseDTOs = new ArrayList<QuestionResponseDTO>();
		questions = questionRepository.findByHomeworkId(homeworkId);
		if (!questions.isEmpty()) {
			for (Question question : questions) {
				QuestionResponseDTO questionResponseDTO = new QuestionResponseDTO();
				questionResponseDTO.setId(question.getId());
				questionResponseDTO.setHomeworkId(question.getHomeworkId());
				questionResponseDTO.setTopic(question.getTopic());
				questionResponseDTO.setAnswerOne(question.getAnswerOne());
				questionResponseDTO.setAnswerTwo(question.getAnswerTwo());
				questionResponseDTO.setAnswerThree(question.getAnswerThree());
				questionResponseDTO.setAnswerFour(question.getAnswerFour());
				questionResponseDTO.setCorrectAnswer(question.getCorrectAnswer());
				questionResponseDTOs.add(questionResponseDTO);
			}
		}
		return questionResponseDTOs;
	}
}
