package com.web.edu.third.party.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.web.edu.third.party.constant.Constant;
import com.web.edu.third.party.entity.VocabularyPart;
import com.web.edu.third.party.requestDTO.VocabularyPartRequestDTO;
import com.web.edu.third.party.service.VocabularyPartService;

@RestController
@RequestMapping("/api/vocabularyPart")
public class VocabularyPartController {
	@Autowired
	private VocabularyPartService vocabularyPartService;

	@GetMapping("/getAllVocabularyPart")
	public List<VocabularyPart> getAllVocabularyPack() {
		return vocabularyPartService.getAllVocabularyPart();
	}

	@GetMapping("/getVocabularyPartsByName")
	public List<VocabularyPart> getVocabularyPacksByName(@RequestParam(name = "name") String name) {
		return vocabularyPartService.getVocabularyPartsByName(name);
	}

	@PostMapping("/createVocabularyPart")
	public String createVocabularyPack(@RequestBody VocabularyPartRequestDTO dto) {
		Boolean check = vocabularyPartService.createAVocabularyPart(dto);
		if (check) {
			return Constant.OK;
		} else {
			throw new ResponseStatusException(HttpStatus.CONFLICT, Constant.UNSUCCESS);
		}
	}
}
