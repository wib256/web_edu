package com.web.edu.third.party.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.edu.third.party.constant.Constant;
import com.web.edu.third.party.entity.VocabularyPart;
import com.web.edu.third.party.repository.VocabularyPartRepository;
import com.web.edu.third.party.requestDTO.VocabularyPartRequestDTO;
import com.web.edu.third.party.service.VocabularyPackService;
import com.web.edu.third.party.service.VocabularyPartService;

@Service
public class VocabularyPartServiceImpl implements VocabularyPartService {
	@Autowired
	private VocabularyPartRepository vocabularyPartRepository;

	@Autowired
	private VocabularyPackService vocabularyPackService;

	@Override
	public List<VocabularyPart> getAllVocabularyPart() {
		List<VocabularyPart> vocabularyParts = new ArrayList<VocabularyPart>();
		vocabularyParts = vocabularyPartRepository.findAll();
		return vocabularyParts;
	}

	@Override
	public Boolean createAVocabularyPart(VocabularyPartRequestDTO dto) {
		try {
			VocabularyPart vocabularyPart = new VocabularyPart();
			vocabularyPart.setName(dto.getName());
			vocabularyPart.setQuantity(Integer.parseInt(Constant.DEFAULT_QUANTITY_OF_PACK));
			vocabularyPart.setVocabularyPackId(dto.getVocabularyPackId());
			vocabularyPartRepository.save(vocabularyPart);
			vocabularyPackService.updateQuantityOfVocabularyPack(dto.getVocabularyPackId(),
					Integer.parseInt(Constant.DEFAULT_INCRESASE_QUANTITY));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<VocabularyPart> getVocabularyPartsByName(String name) {
		List<VocabularyPart> vocabularyParts = new ArrayList<VocabularyPart>();
		vocabularyParts = vocabularyPartRepository.findByNameContainingIgnoreCase(name);
		return vocabularyParts;
	}

	@Override
	public Boolean updateQuantityOfVocabularyPart(int id, int quantity) {
		if (vocabularyPartRepository.countById(id) == 0) {
			return false;
		} else {
			VocabularyPart vocabularyPart = new VocabularyPart();
			vocabularyPart = vocabularyPartRepository.findById(id);
			vocabularyPart.setQuantity(vocabularyPart.getQuantity() + quantity);
			vocabularyPartRepository.save(vocabularyPart);
			return true;
		}
	}

}
