package com.web.edu.third.party.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.FetchType;

@Entity
@Table(name = "vocabulary_pack")
public class VocabularyPack {
	@Id
	@Column(name = "Id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "Name")
	private String name;

	@Column(name = "Quantity")
	private Integer quantity;

	@Column(name = "Username")
	private String teachName;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Username")
	private Teacher teacher;

	@OneToMany(mappedBy = "vocabulary_pack")
	private List<VocabularyPart> vocabularyParts;

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

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public List<VocabularyPart> getVocabularyParts() {
		return vocabularyParts;
	}

	public void setVocabularyParts(List<VocabularyPart> vocabularyParts) {
		this.vocabularyParts = vocabularyParts;
	}

	public String getTeachName() {
		return teachName;
	}

	public void setTeachName(String teachName) {
		this.teachName = teachName;
	}

}
