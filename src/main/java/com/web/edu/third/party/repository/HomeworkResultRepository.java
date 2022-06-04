package com.web.edu.third.party.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.edu.third.party.entity.HomeworkResult;

public interface HomeworkResultRepository extends JpaRepository<HomeworkResult, Integer> {
	List<HomeworkResult> findByHomeworkId(int homeworkId);

	List<HomeworkResult> findByStudentUsername(String studentUsername);

	HomeworkResult getById(int id);
}
