package com.web.edu.third.party.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vocabulary")
public class Vocabulary {
	@Id
	@Column(name = "Id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "Ens_word")
	private String ensWord;

	@Column(name = "Vn_word")
	private String vnWord;

	@Column(name = "Spelling")
	private String spelling;

	@Column(name = "Word_type")
	private String wordType;

	@Column(name = "Example")
	private String example;

	@Column(name = "Vocabulaty_part_id")
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
