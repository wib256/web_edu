package com.web.edu.third.party.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.edu.third.party.entity.StudentCourse;

public interface StudentCourseRepository extends JpaRepository<StudentCourse, Integer> {
	List<StudentCourse> findByStudentUsernameIgnoreCase(String studentName);

	Integer countByStudentUsernameAndCourseLevelId(String studentUsername, int courseId);
}
