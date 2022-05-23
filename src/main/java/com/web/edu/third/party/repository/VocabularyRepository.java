package com.web.edu.third.party.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.edu.third.party.entity.Vocabulary;

public interface VocabularyRepository extends JpaRepository<Vocabulary, Integer> {

}
