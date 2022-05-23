package com.web.edu.third.party.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "teacher")
public class Teacher {
	@Id
	@Column(name = "Username")
	private String username;

	@Column(name = "Image")
	private String image;

	@Column(name = "Name")
	private String name;

	@Column(name = "Email")
	private String email;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Username", insertable = false, updatable = false)
	private Account account;
	
	@OneToMany(mappedBy = "teacher")
	private List<VocabularyPack> vocabularyPacks;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

}
