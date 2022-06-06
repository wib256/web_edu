package com.web.edu.third.party.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.edu.third.party.entity.Homework;

public interface HomeworkRepository extends JpaRepository<Homework, Integer> {
	List<Homework> findByCourseLevelId(int courseLevelId);

	Homework findById(int homeworkId);

	Homework getById(int id);
}
