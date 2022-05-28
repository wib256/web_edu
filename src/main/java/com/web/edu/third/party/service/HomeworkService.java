package com.web.edu.third.party.service;

import java.util.List;

import com.web.edu.third.party.requestDTO.HomeworkRequestDTO;
import com.web.edu.third.party.responseDTO.HomeworkResponseDTO;

public interface HomeworkService {
	Boolean craeteHomework(HomeworkRequestDTO dto);

	List<HomeworkResponseDTO> getHomeworkByCourseId(int couresId);
}
