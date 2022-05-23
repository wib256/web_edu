package com.web.edu.third.party.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.edu.third.party.entity.VocabularyPack;

public interface VocabularyPackRepository extends JpaRepository<VocabularyPack, Integer> {
	List<VocabularyPack> findByNameContainingIgnoreCase(String name);
}
