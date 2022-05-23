package com.web.edu.third.party.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.edu.third.party.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {
	Integer countByName(String name);

	List<Course> getCoursesByName(String name);
}
