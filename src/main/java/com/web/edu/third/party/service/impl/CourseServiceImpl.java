package com.web.edu.third.party.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.edu.third.party.constant.Constant;
import com.web.edu.third.party.entity.Course;
import com.web.edu.third.party.entity.CourseCategory;
import com.web.edu.third.party.entity.CourseLevel;
import com.web.edu.third.party.repository.CourseRepository;
import com.web.edu.third.party.requestDTO.CourseEditRequestDTO;
import com.web.edu.third.party.requestDTO.CourseRequestDTO;
import com.web.edu.third.party.responseDTO.CourseLevelResponseDTO;
import com.web.edu.third.party.responseDTO.CourseResponseDTO;
import com.web.edu.third.party.service.CourseCategoryService;
import com.web.edu.third.party.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseRepository courseRepository;

	@Autowired
	private CourseCategoryService courseCategoryService;

	@Override
	public Boolean createCoures(CourseRequestDTO dto) {
		if (courseRepository.countByName(dto.getName()) == 0) {
			Course course = new Course();
			course.setName(dto.getName());
			course.setDescription(dto.getDescription());
			Course savedCourse = courseRepository.save(course);
			if (dto.getCategoties().size() > 0) {
				for (int i = 0; i < dto.getCategoties().size(); i++) {
					courseCategoryService.saveCourseCategory(savedCourse.getId(), dto.getCategoties().get(i));
				}
			}
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List<CourseResponseDTO> searchCourse(String courseName) {
		List<Course> courses = new ArrayList<Course>();
		List<CourseResponseDTO> courseResponseDTOs = new ArrayList<CourseResponseDTO>();
		courses = courseRepository.getCoursesByName(courseName);
		if (!courses.isEmpty()) {
			for (Course course : courses) {
				CourseResponseDTO courseResponseDTO = new CourseResponseDTO();
				courseResponseDTO.setId(course.getId());
				courseResponseDTO.setName(course.getName());
				courseResponseDTO.setDescription(course.getDescription());
				List<String> categoryName = new ArrayList<String>();
				List<Integer> categoryId = new ArrayList<Integer>();
				if (!course.getCourseCategories().isEmpty()) {
					for (CourseCategory courseCategory : course.getCourseCategories()) {
						categoryName.add(courseCategory.getCategory().getName());
						categoryId.add(courseCategory.getCategory().getId());
					}
				}
				List<CourseLevelResponseDTO> courseLevelResponseDTOs = new ArrayList<CourseLevelResponseDTO>();
				if (!course.getCourseLevels().isEmpty()) {
					for (CourseLevel courseLevel : course.getCourseLevels()) {
						CourseLevelResponseDTO courseLevelResponseDTO = new CourseLevelResponseDTO();
						courseLevelResponseDTO.setId(courseLevel.getId());
						courseLevelResponseDTO.setCourseId(courseLevel.getCourseId());
						courseLevelResponseDTO.setDescription(courseLevel.getDescription());
						courseLevelResponseDTO.setName(courseLevel.getName());
						courseLevelResponseDTO.setPrice(courseLevel.getPrice());
						courseLevelResponseDTOs.add(courseLevelResponseDTO);
					}
				}
				courseResponseDTO.setCourseLevelResponseDTOs(courseLevelResponseDTOs);
				courseResponseDTO.setCourseCategoriesId(categoryId);
				courseResponseDTO.setCategoryName(categoryName);
				courseResponseDTOs.add(courseResponseDTO);
			}
		}
		return courseResponseDTOs;
	}

	@Override
	public List<CourseResponseDTO> getAllCourse() {
		List<Course> courses = new ArrayList<Course>();
		List<CourseResponseDTO> courseResponseDTOs = new ArrayList<CourseResponseDTO>();
		courses = courseRepository.findAll();
		if (!courses.isEmpty()) {
			for (Course course : courses) {
				CourseResponseDTO courseResponseDTO = new CourseResponseDTO();
				if (!course.getStatus().equals(Constant.DEACTIVE)) {
					courseResponseDTO.setId(course.getId());
					courseResponseDTO.setName(course.getName());
					courseResponseDTO.setDescription(course.getDescription());
					List<String> categoryName = new ArrayList<String>();
					List<Integer> categoryId = new ArrayList<Integer>();
					if (!course.getCourseCategories().isEmpty()) {
						for (CourseCategory courseCategory : course.getCourseCategories()) {
							categoryName.add(courseCategory.getCategory().getName());
							categoryId.add(courseCategory.getCategory().getId());
						}
					}
					List<CourseLevelResponseDTO> courseLevelResponseDTOs = new ArrayList<CourseLevelResponseDTO>();
					if (!course.getCourseLevels().isEmpty()) {
						for (CourseLevel courseLevel : course.getCourseLevels()) {
							CourseLevelResponseDTO courseLevelResponseDTO = new CourseLevelResponseDTO();
							courseLevelResponseDTO.setId(courseLevel.getId());
							courseLevelResponseDTO.setCourseId(courseLevel.getCourseId());
							courseLevelResponseDTO.setDescription(courseLevel.getDescription());
							courseLevelResponseDTO.setName(courseLevel.getName());
							courseLevelResponseDTO.setPrice(courseLevel.getPrice());
							courseLevelResponseDTOs.add(courseLevelResponseDTO);
						}
					}
					courseResponseDTO.setCourseLevelResponseDTOs(courseLevelResponseDTOs);
					courseResponseDTO.setCourseCategoriesId(categoryId);
					courseResponseDTO.setCategoryName(categoryName);
					courseResponseDTOs.add(courseResponseDTO);
				}
			}
		}
		return courseResponseDTOs;
	}

	@Override
	public Boolean editCourse(CourseEditRequestDTO dto) {
		Course course = courseRepository.getById(dto.getId());
		if (course != null) {
			if (dto.getDescription() != null) {
				course.setDescription(dto.getDescription());
			}
			if (dto.getName() != null) {
				course.setName(dto.getName());
			}
			courseRepository.save(course);
			return true;
		}
		return false;
	}

	@Override
	public Boolean deleteCourse(int id) {
		Course course = courseRepository.getById(id);
		if (course != null) {
			course.setStatus(Constant.DEACTIVE);
		}
		return null;
	}

}
