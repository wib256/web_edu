package com.web.edu.third.party.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.edu.third.party.entity.Homework;
import com.web.edu.third.party.repository.HomeworkRepository;
import com.web.edu.third.party.requestDTO.HomeworkRequestDTO;
import com.web.edu.third.party.responseDTO.HomeworkResponseDTO;
import com.web.edu.third.party.service.HomeworkService;

@Service
public class HomeworkServiceImpl implements HomeworkService {
	@Autowired
	private HomeworkRepository homeworkRepository;

	@Override
	public Boolean craeteHomework(HomeworkRequestDTO dto) {
		try {
			Homework homework = new Homework();
			homework.setCourseLevelId(dto.getCourseLevelId());
			homework.setDescription(dto.getDescription());
			homework.setName(dto.getName());
			homework.setTeacherUsername(dto.getTeacherUsername());
			homeworkRepository.save(homework);
			return true;
		} catch (Exception e) {
			return false;// TODO: handle exception
		}
	}

	@Override
	public List<HomeworkResponseDTO> getHomeworkByCourseLevelId(int couresLevelId) {
		List<Homework> homeworks = new ArrayList<Homework>();
		List<HomeworkResponseDTO> homeworkResponseDTOs = new ArrayList<HomeworkResponseDTO>();
		homeworks = homeworkRepository.findByCourseLevelId(couresLevelId);
		if (!homeworks.isEmpty()) {
			for (Homework homework : homeworks) {
				HomeworkResponseDTO homeworkResponseDTO = new HomeworkResponseDTO();
				homeworkResponseDTO.setId(homework.getId());
				homeworkResponseDTO.setCourseLevelId(homework.getCourseLevelId());
				homeworkResponseDTO.setName(homework.getName());
				homeworkResponseDTO.setDescription(homework.getDescription());
				homeworkResponseDTO.setTeacherUsername(homework.getTeacherUsername());
				homeworkResponseDTOs.add(homeworkResponseDTO);
			}
		}
		return homeworkResponseDTOs;
	}

	@Override
	public Homework getHomeworkById(int homeworkId) {
		return homeworkRepository.findById(homeworkId);
	}

	@Override
	public Boolean editHomework(HomeworkRequestDTO dto) {
		Homework homework = homeworkRepository.getById(dto.getId());
		if (homework != null) {
			if (dto.getName() != null) {
				homework.setName(dto.getName());
			}
			if (dto.getDescription() != null) {
				homework.setDescription(dto.getDescription());
			}
			homeworkRepository.save(homework);
			return true;
		}
		return false;
	}

}
