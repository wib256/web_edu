package com.web.edu.third.party.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.edu.third.party.entity.StudentAnswer;

public interface StudentAnswerRepository extends JpaRepository<StudentAnswer, Integer> {
	List<StudentAnswer> findByHomeworkResultId(int homeworkResultId);
}
