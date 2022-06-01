package com.web.edu.third.party.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.web.edu.third.party.repository.HomeworkResultRepository;
import com.web.edu.third.party.requestDTO.HomeworkResultDRequestDTO;
import com.web.edu.third.party.responseDTO.HomeworkResultDResponseDTO;
import com.web.edu.third.party.service.HomeworkResultService;
import com.web.edu.third.party.service.StudentAnswerService;

public class HomeworkResultServiceImpl implements HomeworkResultService {
	@Autowired
	private HomeworkResultRepository homeworkResultRepository;

	@Autowired
	private StudentAnswerService studentAnswerService;

	@Override
	public HomeworkResultDResponseDTO createHomeworkResult(HomeworkResultDRequestDTO dto) {
		try {
			if (!dto.getStudentAnswerRequestDTOs().isEmpty()) {
				studentAnswerService.saveAnswers(dto.getStudentAnswerRequestDTOs());
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}

		return null;
	}

	@Override
	public HomeworkResultDResponseDTO getHomeworkResultByHomeworkResultId(int homeworkResultId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HomeworkResultDResponseDTO getHomeworkResultByStudentUsername(String studentUsername) {
		// TODO Auto-generated method stub
		return null;
	}

}
