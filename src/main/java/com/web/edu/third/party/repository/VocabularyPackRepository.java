package com.web.edu.third.party.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.edu.third.party.entity.VocabularyPack;

public interface VocabularyPackRepository extends JpaRepository<VocabularyPack, Integer> {
	Integer countById(int id);

	VocabularyPack findById(int id);

	List<VocabularyPack> findByNameContainingIgnoreCase(String name);
	
	List<VocabularyPack> findByCourseLevelId(int courseLevelId);
	
	List<VocabularyPack> findByName(String name);
}
