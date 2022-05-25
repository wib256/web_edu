package com.web.edu.third.party.service;

import java.util.List;

import com.web.edu.third.party.entity.Vocabulary;
import com.web.edu.third.party.requestDTO.VocabularyRequestDTO;

public interface VocabularyService {
	List<Vocabulary> getAllVocabulary();

	Boolean createAVocabulary(VocabularyRequestDTO dto);
}
