package com.web.edu.third.party.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.edu.third.party.entity.Homework;
import com.web.edu.third.party.entity.HomeworkResult;
import com.web.edu.third.party.entity.StudentAnswer;
import com.web.edu.third.party.repository.HomeworkResultRepository;
import com.web.edu.third.party.requestDTO.HomeworkResultDRequestDTO;
import com.web.edu.third.party.responseDTO.HomeworkResultDResponseDTO;
import com.web.edu.third.party.responseDTO.HomeworkResultResponse;
import com.web.edu.third.party.service.HomeworkResultService;
import com.web.edu.third.party.service.HomeworkService;
import com.web.edu.third.party.service.StudentAnswerService;

@Service
public class HomeworkResultServiceImpl implements HomeworkResultService {
	@Autowired
	private HomeworkResultRepository homeworkResultRepository;

	@Autowired
	private StudentAnswerService studentAnswerService;

	@Autowired
	private HomeworkService homeworkService;

	@Override
	public HomeworkResultDResponseDTO createHomeworkResult(HomeworkResultDRequestDTO dto) {
		try {

			Homework homework = homeworkService.getHomeworkById(dto.getHomeworkId());
			List<HomeworkResultResponse> homeworkResultResponses = new ArrayList<HomeworkResultResponse>();
			int correctAnswser = 0;
			if (!homework.getQuestions().isEmpty()) {
				for (int i = 0; i < homework.getQuestions().size(); i++) {
					if (dto.getStudentAnswerRequestDTOs().get(i).getAnswer() != null) {
						if (dto.getStudentAnswerRequestDTOs().get(i).getAnswer()
								.equalsIgnoreCase(homework.getQuestions().get(i).getCorrectAnswer())) {
							correctAnswser = correctAnswser + 1;
						}
					}
					HomeworkResultResponse homeworkResultResponse = new HomeworkResultResponse();
					homeworkResultResponse.setTopic(homework.getQuestions().get(i).getTopic());
					homeworkResultResponse.setCorrectAnswer(homework.getQuestions().get(i).getCorrectAnswer());
					homeworkResultResponse.setYourAnwser(dto.getStudentAnswerRequestDTOs().get(i).getAnswer());
					homeworkResultResponses.add(homeworkResultResponse);
				}
			}
			HomeworkResult homeworkResult = new HomeworkResult();
			homeworkResult.setHomeworkId(dto.getHomeworkId());
			homeworkResult.setStudentUsername(dto.getStudentUsername());
			double point = Double.parseDouble("" + correctAnswser)
					/ Double.parseDouble("" + homework.getQuestions().size());
			homeworkResult.setPoint(point * 10);
			homeworkResult = homeworkResultRepository.save(homeworkResult);
			HomeworkResultDResponseDTO homeworkResultDResponseDTO = new HomeworkResultDResponseDTO();
			homeworkResultDResponseDTO.setHomeworkId(dto.getHomeworkId());
			homeworkResultDResponseDTO.setHomeworkResultResponses(homeworkResultResponses);
			homeworkResultDResponseDTO.setId(homeworkResult.getId());
			homeworkResultDResponseDTO.setPoint(homeworkResult.getPoint());
			homeworkResultDResponseDTO.setStudentUsername(dto.getStudentUsername());
			if (!dto.getStudentAnswerRequestDTOs().isEmpty()) {
				studentAnswerService.saveAnswers(dto.getStudentAnswerRequestDTOs(), homeworkResult.getId());
			}
			return homeworkResultDResponseDTO;
		} catch (Exception e) {
			return null;
		}
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

	@Override
	public List<HomeworkResultDResponseDTO> getHomeworkResultByHomeworkId(int homeworkId) {
		List<HomeworkResultDResponseDTO> homeworkResultDResponseDTOs = new ArrayList<HomeworkResultDResponseDTO>();
		List<HomeworkResult> homeworkResults = new ArrayList<HomeworkResult>();
		homeworkResults = homeworkResultRepository.findByHomeworkId(homeworkId);
		if (!homeworkResults.isEmpty()) {
			for (HomeworkResult homeworkResult : homeworkResults) {
				List<HomeworkResultResponse> homeworkResultResponses = new ArrayList<HomeworkResultResponse>();
				List<StudentAnswer> studentAnswers = studentAnswerService
						.getStudentAnswersByHomeworkResultId(homeworkResult.getHomeworkId());
				for (int i = 0; i < homeworkResult.getHomework().getQuestions().size(); i++) {
					HomeworkResultResponse homeworkResultResponse = new HomeworkResultResponse();
					homeworkResultResponse.setTopic(homeworkResult.getHomework().getQuestions().get(i).getTopic());
					homeworkResultResponse
							.setCorrectAnswer(homeworkResult.getHomework().getQuestions().get(i).getCorrectAnswer());
					homeworkResultResponse.setYourAnwser(studentAnswers.get(i).getAnswer());
					homeworkResultResponses.add(homeworkResultResponse);
				}
				HomeworkResultDResponseDTO homeworkResultDResponseDTO = new HomeworkResultDResponseDTO();
				homeworkResultDResponseDTO.setHomeworkId(homeworkResult.getHomeworkId());
				homeworkResultDResponseDTO.setHomeworkResultResponses(homeworkResultResponses);
				homeworkResultDResponseDTO.setId(homeworkResult.getId());
				homeworkResultDResponseDTO.setPoint(homeworkResult.getPoint());
				homeworkResultDResponseDTO.setStudentUsername(homeworkResult.getStudentUsername());
				homeworkResultDResponseDTOs.add(homeworkResultDResponseDTO);
			}
		}
		return homeworkResultDResponseDTOs;
	}

}
