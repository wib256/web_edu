package com.web.edu.third.party.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "admin")
public class Admin {
	@Id
	@Column(name = "Username")
	private String username;

	@Column(name = "Image")
	private String image;

	@Column(name = "Name")
	private String name;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Username", insertable = false, updatable = false)
	private Account account;

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

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

}
