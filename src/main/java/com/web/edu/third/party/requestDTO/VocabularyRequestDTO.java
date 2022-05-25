package com.web.edu.third.party.requestDTO;

public class VocabularyRequestDTO {
	private Integer id;
	private String ensWord;
	private String vnWord;
	private String spelling;
	private String wordType;
	private String example;
	private Integer vocabulatyPartId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEnsWord() {
		return ensWord;
	}

	public void setEnsWord(String ensWord) {
		this.ensWord = ensWord;
	}

	public String getVnWord() {
		return vnWord;
	}

	public void setVnWord(String vnWord) {
		this.vnWord = vnWord;
	}

	public String getSpelling() {
		return spelling;
	}

	public void setSpelling(String spelling) {
		this.spelling = spelling;
	}

	public String getWordType() {
		return wordType;
	}

	public void setWordType(String wordType) {
		this.wordType = wordType;
	}

	public String getExample() {
		return example;
	}

	public void setExample(String example) {
		this.example = example;
	}

	public Integer getVocabulatyPartId() {
		return vocabulatyPartId;
	}

	public void setVocabulatyPartId(Integer vocabulatyPartId) {
		this.vocabulatyPartId = vocabulatyPartId;
	}

}
