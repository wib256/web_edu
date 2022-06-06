package com.web.edu.third.party.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.web.edu.third.party.constant.Constant;
import com.web.edu.third.party.entity.Vocabulary;
import com.web.edu.third.party.requestDTO.VocabularyRequestDTO;
import com.web.edu.third.party.service.VocabularyService;

@RestController
@RequestMapping("/api/vocabulary")
public class VocabularyController {
	@Autowired
	private VocabularyService vocabularyService;

	@GetMapping("/getAllVocabulary")
	public List<Vocabulary> getAllVocabularyPack() {
		return vocabularyService.getAllVocabulary();
	}

	@GetMapping("/getVocabularyByVocabularyPartId/{vocabularyPartId}")
	public List<Vocabulary> getVocabularyByVocabularyPartId(@PathVariable int vocabularyPartId) {
		return vocabularyService.getVocabularyByVocabularyPartId(vocabularyPartId);
	}

	@PostMapping("/createVocabulary")
	public String createVocabulary(@RequestBody VocabularyRequestDTO dto) {
		Boolean check = vocabularyService.createAVocabulary(dto);
		if (check) {
			return Constant.OK;
		} else {
			throw new ResponseStatusException(HttpStatus.CONFLICT, Constant.UNSUCCESS);
		}
	}

	@PutMapping("/editVocabulary")
	public String editVocabulary(@RequestBody VocabularyRequestDTO dto) {
		Boolean check = vocabularyService.editVocabulary(dto);
		if (check) {
			return Constant.OK;
		} else {
			throw new ResponseStatusException(HttpStatus.CONFLICT, Constant.UNSUCCESS);
		}
	}

	@DeleteMapping("/deleteVocabulary/{id}")
	public Boolean deleteVocabulary(@PathVariable int id) {
		return vocabularyService.deleteVocabulary(id);
	}
}
