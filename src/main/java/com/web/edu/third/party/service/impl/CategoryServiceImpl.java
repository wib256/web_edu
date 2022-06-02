package com.web.edu.third.party.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.web.edu.third.party.constant.Constant;
import com.web.edu.third.party.entity.Category;
import com.web.edu.third.party.repository.CategoryRepository;
import com.web.edu.third.party.responseDTO.CategoryResponseDTO;
import com.web.edu.third.party.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryRepository courseCategoryRepository;

	@Override
	public Boolean createCategory(String name) {
		if (courseCategoryRepository.countByName(name) == 0) {
			Category courseCategory = new Category();
			courseCategory.setName(name);
			courseCategoryRepository.save(courseCategory);
			return true;
		} else {
			throw new ResponseStatusException(HttpStatus.CONFLICT, Constant.ERROR_COURSE_CATEGORY);
		}
	}

	@Override
	public List<CategoryResponseDTO> getAllCateCourseCategory() {
		List<Category> list = new ArrayList<Category>();
		List<CategoryResponseDTO> categoryResponseDTOs = new ArrayList<CategoryResponseDTO>();
		list = courseCategoryRepository.findAll();
		if (!list.isEmpty()) {
			for (Category category : list) {
				CategoryResponseDTO categoryResponseDTO = new CategoryResponseDTO();
				categoryResponseDTO.setId(category.getId());
				categoryResponseDTO.setName(category.getName());
				categoryResponseDTOs.add(categoryResponseDTO);
			}
		}

		return categoryResponseDTOs;
	}

}
