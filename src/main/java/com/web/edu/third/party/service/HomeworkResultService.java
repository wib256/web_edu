package com.web.edu.third.party.service;

import java.util.List;

import com.web.edu.third.party.requestDTO.HomeworkResultDRequestDTO;
import com.web.edu.third.party.responseDTO.HomeworkResultDResponseDTO;

public interface HomeworkResultService {
	HomeworkResultDResponseDTO createHomeworkResult(HomeworkResultDRequestDTO dto);

	HomeworkResultDResponseDTO getHomeworkResultByHomeworkResultId(int homeworkResultId);

	HomeworkResultDResponseDTO getHomeworkResultByStudentUsername(String studentUsername);

	List<HomeworkResultDResponseDTO> getHomeworkResultByHomeworkId(int homeworkId);
}
