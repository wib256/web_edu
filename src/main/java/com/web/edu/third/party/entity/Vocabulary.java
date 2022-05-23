package com.web.edu.third.party.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "vocabulary")
public class Vocabulary {
	@Id
	@Column(name = "Id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "ens_word")
	private String ensWord;

	@Column(name = "vn_word")
	private String vnWord;

	@Column(name = "spelling")
	private String spelling;

	@Column(name = "Vocabulaty_part_id")
	private Integer vocabulatyPartId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Vocabulaty_part_id")
	private VocabularyPart vocabularyPart;

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

	public VocabularyPart getVocabularyPart() {
		return vocabularyPart;
	}

	public void setVocabularyPart(VocabularyPart vocabularyPart) {
		this.vocabularyPart = vocabularyPart;
	}

	public Integer getVocabulatyPartId() {
		return vocabulatyPartId;
	}

	public void setVocabulatyPartId(Integer vocabulatyPartId) {
		this.vocabulatyPartId = vocabulatyPartId;
	}

}
