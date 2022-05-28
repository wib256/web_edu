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
			homework.setCourseId(dto.getCourseId());
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
	public List<HomeworkResponseDTO> getHomeworkByCourseId(int couresId) {
		List<Homework> homeworks = new ArrayList<Homework>();
		List<HomeworkResponseDTO> homeworkResponseDTOs = new ArrayList<HomeworkResponseDTO>();
		homeworks = homeworkRepository.findByCourseId(couresId);
		if (!homeworks.isEmpty()) {
			for (Homework homework : homeworks) {
				HomeworkResponseDTO homeworkResponseDTO = new HomeworkResponseDTO();
				homeworkResponseDTO.setId(homework.getId());
				homeworkResponseDTO.setCourseId(homework.getCourseId());
				homeworkResponseDTO.setName(homework.getName());
				homeworkResponseDTO.setDescription(homework.getDescription());
				homeworkResponseDTO.setTeacherUsername(homework.getTeacherUsername());
				homeworkResponseDTOs.add(homeworkResponseDTO);
			}
		}
		return homeworkResponseDTOs;
	}

}
