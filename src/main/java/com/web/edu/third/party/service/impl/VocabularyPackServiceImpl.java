package com.web.edu.third.party.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.edu.third.party.constant.Constant;
import com.web.edu.third.party.entity.VocabularyPack;
import com.web.edu.third.party.repository.VocabularyPackRepository;
import com.web.edu.third.party.requestDTO.VocabularyPackRequestDTO;
import com.web.edu.third.party.responseDTO.VocabularyPackResponseDTO;
import com.web.edu.third.party.service.VocabularyPackService;

@Service
public class VocabularyPackServiceImpl implements VocabularyPackService {
	@Autowired
	private VocabularyPackRepository vocabularyPackRepository;

	@Override
	public List<VocabularyPackResponseDTO> getAllVocabularyPack() {
		List<VocabularyPack> vocabularyPacks = new ArrayList<VocabularyPack>();
		List<VocabularyPackResponseDTO> vocabularyPackResponseDTOs = new ArrayList<VocabularyPackResponseDTO>();

		vocabularyPacks = vocabularyPackRepository.findAll();
		if (!vocabularyPacks.isEmpty()) {
			for (VocabularyPack vocabularyPack : vocabularyPacks) {
				VocabularyPackResponseDTO vocabularyPackResponseDTO = new VocabularyPackResponseDTO();
				vocabularyPackResponseDTO.setId(vocabularyPack.getId());
				vocabularyPackResponseDTO.setCourseLevelId(vocabularyPack.getCourseLevelId());
				vocabularyPackResponseDTO.setName(vocabularyPack.getName());
				vocabularyPackResponseDTO.setQuantity(vocabularyPack.getQuantity());
				vocabularyPackResponseDTOs.add(vocabularyPackResponseDTO);
			}
			return vocabularyPackResponseDTOs;
		}
		return vocabularyPackResponseDTOs;
	}

	@Override
	public Boolean createAVocabularyPack(VocabularyPackRequestDTO dto) {
		try {
			VocabularyPack vocabularyPack = new VocabularyPack();
			vocabularyPack.setCourseLevelId(dto.getCourseLevelId());
			vocabularyPack.setName(dto.getName());
			vocabularyPack.setQuantity(Integer.parseInt(Constant.DEFAULT_QUANTITY_OF_PACK));
			vocabularyPack.setTeachName(dto.getTeachName());
			vocabularyPackRepository.save(vocabularyPack);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	@Override
	public List<VocabularyPackResponseDTO> getVocabularyPacksByName(String name) {
		List<VocabularyPack> vocabularyPacks = new ArrayList<VocabularyPack>();
		List<VocabularyPackResponseDTO> vocabularyPackResponseDTOs = new ArrayList<VocabularyPackResponseDTO>();

		vocabularyPacks = vocabularyPackRepository.findByNameContainingIgnoreCase(name);
		if (!vocabularyPacks.isEmpty()) {
			for (VocabularyPack vocabularyPack : vocabularyPacks) {
				VocabularyPackResponseDTO vocabularyPackResponseDTO = new VocabularyPackResponseDTO();
				vocabularyPackResponseDTO.setId(vocabularyPack.getId());
				vocabularyPackResponseDTO.setCourseLevelId(vocabularyPack.getCourseLevelId());
				vocabularyPackResponseDTO.setName(vocabularyPack.getName());
				vocabularyPackResponseDTO.setQuantity(vocabularyPack.getQuantity());
				vocabularyPackResponseDTOs.add(vocabularyPackResponseDTO);
			}
			return vocabularyPackResponseDTOs;
		}
		return vocabularyPackResponseDTOs;
	}

	@Override
	public Boolean updateQuantityOfVocabularyPack(int id, int quantity) {
		if (vocabularyPackRepository.countById(id) == 0) {
			return false;
		} else {
			VocabularyPack vocabularyPack = new VocabularyPack();
			vocabularyPack = vocabularyPackRepository.findById(id);
			vocabularyPack.setQuantity(vocabularyPack.getQuantity() + quantity);
			vocabularyPackRepository.save(vocabularyPack);
			return true;
		}
	}

}
