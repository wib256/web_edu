package com.web.edu.third.party.service;

import java.util.List;

import com.web.edu.third.party.responseDTO.CategoryResponseDTO;

public interface CategoryService {
	Boolean createCategory(String name);

	List<CategoryResponseDTO> getAllCateCourseCategory();
}
