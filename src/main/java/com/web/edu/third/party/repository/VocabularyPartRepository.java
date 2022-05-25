package com.web.edu.third.party.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.edu.third.party.entity.VocabularyPart;

public interface VocabularyPartRepository extends JpaRepository<VocabularyPart, Integer> {
	Integer countById(int id);

	List<VocabularyPart> findByNameContainingIgnoreCase(String name);
}
