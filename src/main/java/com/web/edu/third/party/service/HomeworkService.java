package com.web.edu.third.party.service;

import java.util.List;

import com.web.edu.third.party.entity.Homework;
import com.web.edu.third.party.requestDTO.HomeworkRequestDTO;
import com.web.edu.third.party.responseDTO.HomeworkResponseDTO;

public interface HomeworkService {
	Boolean craeteHomework(HomeworkRequestDTO dto);

	List<HomeworkResponseDTO> getHomeworkByCourseLevelId(int couresLevelId);

	Homework getHomeworkById(int homeworkId);

	Boolean editHomework(HomeworkRequestDTO dto);
}
