package com.web.edu.third.party.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "vocabulary_part")
public class VocabularyPart {
	@Id
	@Column(name = "Id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "Name")
	private String name;

	@Column(name = "Quantity")
	private Integer quantity;

	@Column(name = "Vocabulary_pack_id")
	private Integer vocabularyPackId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "vocabulary_pack_id")
	private VocabularyPack vocabularyPack;

	@OneToMany(mappedBy = "vocabulary_part")
	private List<Vocabulary> vocabularies;

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

	public VocabularyPack getVocabularyPack() {
		return vocabularyPack;
	}

	public void setVocabularyPack(VocabularyPack vocabularyPack) {
		this.vocabularyPack = vocabularyPack;
	}

	public List<Vocabulary> getVocabularies() {
		return vocabularies;
	}

	public void setVocabularies(List<Vocabulary> vocabularies) {
		this.vocabularies = vocabularies;
	}

	public Integer getVocabularyPackId() {
		return vocabularyPackId;
	}

	public void setVocabularyPackId(Integer vocabularyPackId) {
		this.vocabularyPackId = vocabularyPackId;
	}

}
