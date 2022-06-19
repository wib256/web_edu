package com.web.edu.third.party.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.edu.third.party.constant.Constant;
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
					homeworkResultResponse.setCorrectAnswer(getAnswer(homework.getQuestions().get(i).getCorrectAnswer(),
							homework.getQuestions().get(i).getAnswerOne(),
							homework.getQuestions().get(i).getAnswerTwo(),
							homework.getQuestions().get(i).getAnswerThree(),
							homework.getQuestions().get(i).getAnswerFour()));
					homeworkResultResponse.setYourAnwser(getAnswer(dto.getStudentAnswerRequestDTOs().get(i).getAnswer(),
							homework.getQuestions().get(i).getAnswerOne(),
							homework.getQuestions().get(i).getAnswerTwo(),
							homework.getQuestions().get(i).getAnswerThree(),
							homework.getQuestions().get(i).getAnswerFour()));
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
		HomeworkResult homeworkResult = homeworkResultRepository.getById(homeworkResultId);

		List<HomeworkResultResponse> homeworkResultResponses = new ArrayList<HomeworkResultResponse>();
		List<HomeworkResultDResponseDTO> homeworkResultDResponseDTOs = new ArrayList<HomeworkResultDResponseDTO>();
		if (!homeworkResult.getHomework().getQuestions().isEmpty()) {

			List<StudentAnswer> studentAnswers = studentAnswerService
					.getStudentAnswersByHomeworkResultId(homeworkResult.getId());
			for (int i = 0; i < homeworkResult.getHomework().getQuestions().size(); i++) {
				HomeworkResultResponse homeworkResultResponse = new HomeworkResultResponse();
				homeworkResultResponse.setTopic(homeworkResult.getHomework().getQuestions().get(i).getTopic());
				homeworkResultResponse.setCorrectAnswer(
						getAnswer(homeworkResult.getHomework().getQuestions().get(i).getCorrectAnswer(),
								homeworkResult.getHomework().getQuestions().get(i).getAnswerOne(),
								homeworkResult.getHomework().getQuestions().get(i).getAnswerTwo(),
								homeworkResult.getHomework().getQuestions().get(i).getAnswerThree(),
								homeworkResult.getHomework().getQuestions().get(i).getAnswerFour()));

				homeworkResultResponse.setYourAnwser(getAnswer(studentAnswers.get(i).getAnswer(),
						homeworkResult.getHomework().getQuestions().get(i).getAnswerOne(),
						homeworkResult.getHomework().getQuestions().get(i).getAnswerTwo(),
						homeworkResult.getHomework().getQuestions().get(i).getAnswerThree(),
						homeworkResult.getHomework().getQuestions().get(i).getAnswerFour()));

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

		HomeworkResultDResponseDTO homeworkResultDResponseDTO = new HomeworkResultDResponseDTO();
		homeworkResultDResponseDTO.setId(homeworkResult.getId());
		homeworkResultDResponseDTO.setHomeworkId(homeworkResult.getHomeworkId());
		homeworkResultDResponseDTO.setPoint(homeworkResult.getPoint());
		homeworkResultDResponseDTO.setStudentUsername(homeworkResult.getStudentUsername());
		homeworkResultDResponseDTO.setHomeworkResultResponses(homeworkResultResponses);
		return homeworkResultDResponseDTO;
	}

	@Override
	public List<HomeworkResultDResponseDTO> getHomeworkResultByStudentUsername(String studentUsername) {
		List<HomeworkResult> homeworkResults = homeworkResultRepository.findByStudentUsername(studentUsername);
		List<HomeworkResultDResponseDTO> homeworkResultDResponseDTOs = new ArrayList<HomeworkResultDResponseDTO>();
		if (!homeworkResults.isEmpty()) {
			for (HomeworkResult homeworkResult : homeworkResults) {
				List<HomeworkResultResponse> homeworkResultResponses = new ArrayList<HomeworkResultResponse>();
				List<StudentAnswer> studentAnswers = studentAnswerService
						.getStudentAnswersByHomeworkResultId(homeworkResult.getId());
				for (int i = 0; i < homeworkResult.getHomework().getQuestions().size(); i++) {
					HomeworkResultResponse homeworkResultResponse = new HomeworkResultResponse();
					homeworkResultResponse.setTopic(homeworkResult.getHomework().getQuestions().get(i).getTopic());
					homeworkResultResponse.setCorrectAnswer(
							getAnswer(homeworkResult.getHomework().getQuestions().get(i).getCorrectAnswer(),
									homeworkResult.getHomework().getQuestions().get(i).getAnswerOne(),
									homeworkResult.getHomework().getQuestions().get(i).getAnswerTwo(),
									homeworkResult.getHomework().getQuestions().get(i).getAnswerThree(),
									homeworkResult.getHomework().getQuestions().get(i).getAnswerFour()));

					homeworkResultResponse.setYourAnwser(getAnswer(studentAnswers.get(i).getAnswer(),
							homeworkResult.getHomework().getQuestions().get(i).getAnswerOne(),
							homeworkResult.getHomework().getQuestions().get(i).getAnswerTwo(),
							homeworkResult.getHomework().getQuestions().get(i).getAnswerThree(),
							homeworkResult.getHomework().getQuestions().get(i).getAnswerFour()));
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
					homeworkResultResponse.setCorrectAnswer(
							getAnswer(homeworkResult.getHomework().getQuestions().get(i).getCorrectAnswer(),
									homeworkResult.getHomework().getQuestions().get(i).getAnswerOne(),
									homeworkResult.getHomework().getQuestions().get(i).getAnswerTwo(),
									homeworkResult.getHomework().getQuestions().get(i).getAnswerThree(),
									homeworkResult.getHomework().getQuestions().get(i).getAnswerFour()));

					homeworkResultResponse.setYourAnwser(getAnswer(studentAnswers.get(i).getAnswer(),
							homeworkResult.getHomework().getQuestions().get(i).getAnswerOne(),
							homeworkResult.getHomework().getQuestions().get(i).getAnswerTwo(),
							homeworkResult.getHomework().getQuestions().get(i).getAnswerThree(),
							homeworkResult.getHomework().getQuestions().get(i).getAnswerFour()));
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

	private String getAnswer(String yourAnswer, String answerOne, String answerTwo, String answerThree,
			String answerFour) {
		switch (yourAnswer) {
		case Constant.ANSWER_ONE:
			return answerOne;
		case Constant.ANSWER_TWO:
			return answerTwo;
		case Constant.ANSWER_THREE:
			return answerThree;
		case Constant.ANSWER_FOUR:
			return answerFour;
		default:
			return "";
		}
	}
}
