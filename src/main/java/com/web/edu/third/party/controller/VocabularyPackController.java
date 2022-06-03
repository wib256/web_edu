package com.web.edu.third.party.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.web.edu.third.party.constant.Constant;
import com.web.edu.third.party.requestDTO.VocabularyPackRequestDTO;
import com.web.edu.third.party.responseDTO.VocabularyPackResponseDTO;
import com.web.edu.third.party.service.VocabularyPackService;

@RestController
@RequestMapping("/api/vocabularyPack")
public class VocabularyPackController {
	@Autowired
	private VocabularyPackService vocabularyPackService;

	@GetMapping("/getAllVocabularyPack")
	public List<VocabularyPackResponseDTO> getAllVocabularyPack() {
		return vocabularyPackService.getAllVocabularyPack();
	}

	@GetMapping("/getVocabularyPacksByName")
	public List<VocabularyPackResponseDTO> getVocabularyPacksByName(@RequestParam(name = "name") String name) {
		return vocabularyPackService.getVocabularyPacksByName(name);
	}

	@GetMapping("/getVocabularyPacksByCourseLevelId/{courseLevelId}")
	public List<VocabularyPackResponseDTO> getVocabularyPacksByCourseLevelId(@PathVariable int courseLevelId) {
		return vocabularyPackService.getVocabularyPacksByCourseLevelId(courseLevelId);
	}

	@PostMapping("/createVocabularyPack")
	public String createVocabularyPack(@RequestBody VocabularyPackRequestDTO dto) {
		Boolean check = vocabularyPackService.createAVocabularyPack(dto);
		if (check) {
			return Constant.OK;
		} else {
			throw new ResponseStatusException(HttpStatus.CONFLICT, Constant.UNSUCCESS);
		}
	}
}
