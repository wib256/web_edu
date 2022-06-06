package com.web.edu.third.party.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.edu.third.party.constant.Constant;
import com.web.edu.third.party.entity.Vocabulary;
import com.web.edu.third.party.repository.VocabularyRepository;
import com.web.edu.third.party.requestDTO.VocabularyRequestDTO;
import com.web.edu.third.party.service.VocabularyPartService;
import com.web.edu.third.party.service.VocabularyService;

@Service
public class VocabularyServiceImpl implements VocabularyService {
	@Autowired
	private VocabularyRepository vocabularyRepository;

	@Autowired
	private VocabularyPartService vocabularyPartService;

	@Override
	public List<Vocabulary> getAllVocabulary() {
		List<Vocabulary> vocabularies = new ArrayList<Vocabulary>();
		vocabularies = vocabularyRepository.findAll();
		return vocabularies;
	}

	@Override
	public Boolean createAVocabulary(VocabularyRequestDTO dto) {
		try {
			Vocabulary vocabulary = new Vocabulary();
			vocabulary.setEnsWord(dto.getEnsWord());
			vocabulary.setVnWord(dto.getVnWord());
			vocabulary.setSpelling(dto.getSpelling());
			vocabulary.setWordType(dto.getWordType());
			vocabulary.setExample(dto.getExample());
			vocabulary.setVocabulatyPartId(dto.getVocabulatyPartId());
			vocabularyRepository.save(vocabulary);
			vocabularyPartService.updateQuantityOfVocabularyPart(dto.getVocabulatyPartId(),
					Integer.parseInt(Constant.DEFAULT_INCRESASE_QUANTITY));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<Vocabulary> getVocabularyByVocabularyPartId(int vocabularyPartId) {
		List<Vocabulary> vocabularies = new ArrayList<Vocabulary>();
		vocabularies = vocabularyRepository.findByVocabulatyPartId(vocabularyPartId);
		return vocabularies;
	}

	@Override
	public Boolean editVocabulary(VocabularyRequestDTO dto) {
		Vocabulary vocabulary = vocabularyRepository.getById(dto.getId());
		if (vocabulary != null) {
			if (dto.getEnsWord() != null) {
				vocabulary.setEnsWord(dto.getEnsWord());
			}
			if (dto.getExample() != null) {
				vocabulary.setExample(dto.getExample());
			}
			if (dto.getSpelling() != null) {
				vocabulary.setSpelling(dto.getSpelling());
			}
			if (dto.getVnWord() != null) {
				vocabulary.setVnWord(dto.getVnWord());
			}
			if (dto.getVocabulatyPartId() != null) {
				vocabulary.setVocabulatyPartId(dto.getVocabulatyPartId());
			}
			if (dto.getWordType() != null) {
				vocabulary.setWordType(dto.getWordType());
			}
			vocabularyRepository.save(vocabulary);
			return true;
		}
		return false;
	}

	@Override
	public Boolean deleteVocabulary(int id) {
		if (vocabularyRepository.countById(id) > 0) {
			vocabularyRepository.deleteById(id);
			vocabularyPartService.updateQuantityOfVocabularyPart(id, -1);
			return true;
		}
		return false;
	}

}
