package com.web.edu.third.party.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.edu.third.party.entity.Vocabulary;

public interface VocabularyRepository extends JpaRepository<Vocabulary, Integer> {
	Integer countById(int id);

	List<Vocabulary> findByVocabulatyPartId(int vocabularyPaetId);

	Vocabulary getById(int id);
}
