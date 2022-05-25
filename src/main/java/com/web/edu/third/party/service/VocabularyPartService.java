package com.web.edu.third.party.service;

import java.util.List;

import com.web.edu.third.party.entity.VocabularyPart;
import com.web.edu.third.party.requestDTO.VocabularyPartRequestDTO;

public interface VocabularyPartService {
	List<VocabularyPart> getAllVocabularyPart();

	Boolean createAVocabularyPart(VocabularyPartRequestDTO dto);

	List<VocabularyPart> getVocabularyPartsByName(String name);

	Boolean updateQuantityOfVocabularyPart(int id, int quantity);
}
