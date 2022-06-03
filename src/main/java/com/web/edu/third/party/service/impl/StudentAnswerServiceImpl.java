package com.web.edu.third.party.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.edu.third.party.entity.StudentAnswer;
import com.web.edu.third.party.repository.StudentAnswerRepository;
import com.web.edu.third.party.requestDTO.StudentAnswerRequestDTO;
import com.web.edu.third.party.service.StudentAnswerService;

@Service
public class StudentAnswerServiceImpl implements StudentAnswerService {
	@Autowired
	private StudentAnswerRepository studentAnswerRepository;

	@Override
	public Boolean saveAnswers(List<StudentAnswerRequestDTO> dtos, int homeworkResultId) {
		try {
			if (!dtos.isEmpty()) {
				List<StudentAnswer> studentAnswers = new ArrayList<StudentAnswer>();
				for (StudentAnswerRequestDTO studentAnswerRequestDTO : dtos) {
					StudentAnswer studentAnswer = new StudentAnswer();
					studentAnswer.setAnswer(studentAnswerRequestDTO.getAnswer());
					studentAnswer.setHomeworkResultId(homeworkResultId);
					studentAnswers.add(studentAnswer);
				}
				studentAnswerRepository.saveAll(studentAnswers);
				return true;
			}
		} catch (Exception e) {
			return false;
		}
		return false;
	}

	@Override
	public List<StudentAnswer> getStudentAnswersByHomeworkResultId(int homeworkResultId) {
		return studentAnswerRepository.findByHomeworkResultId(homeworkResultId);
	}

}
