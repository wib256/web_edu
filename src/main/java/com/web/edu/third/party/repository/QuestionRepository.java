package com.web.edu.third.party.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.edu.third.party.entity.Question;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
	List<Question> findByHomeworkId(int homeworkId);
}
