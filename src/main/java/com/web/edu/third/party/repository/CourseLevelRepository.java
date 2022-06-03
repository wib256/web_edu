package com.web.edu.third.party.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.edu.third.party.entity.CourseLevel;

public interface CourseLevelRepository extends JpaRepository<CourseLevel, Integer> {
	List<CourseLevel> findByCourseId(int courseId);
}
