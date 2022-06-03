package com.web.edu.third.party.service;

import java.util.List;

import com.web.edu.third.party.requestDTO.VocabularyPackRequestDTO;
import com.web.edu.third.party.responseDTO.VocabularyPackResponseDTO;

public interface VocabularyPackService {
	List<VocabularyPackResponseDTO> getAllVocabularyPack();

	Boolean createAVocabularyPack(VocabularyPackRequestDTO dto);

	List<VocabularyPackResponseDTO> getVocabularyPacksByName(String name);

	Boolean updateQuantityOfVocabularyPack(int id, int quantity);

	List<VocabularyPackResponseDTO> getVocabularyPacksByCourseLevelId(int courseLevelId);
}
