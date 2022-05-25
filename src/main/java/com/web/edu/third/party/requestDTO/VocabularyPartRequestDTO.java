package com.web.edu.third.party.requestDTO;

public class VocabularyPartRequestDTO {
	private Integer id;
	private String name;
	private Integer quantity;
	private Integer vocabularyPackId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getVocabularyPackId() {
		return vocabularyPackId;
	}

	public void setVocabularyPackId(Integer vocabularyPackId) {
		this.vocabularyPackId = vocabularyPackId;
	}

}
