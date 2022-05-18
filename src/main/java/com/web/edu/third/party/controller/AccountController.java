package com.web.edu.third.party.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.edu.third.party.requestDTO.AccountRequestDTO;
import com.web.edu.third.party.service.AccountService;

@RestController
@RequestMapping("/api/account")
public class AccountController {
	@Autowired
	AccountService accountService;

	@PostMapping("/createAccount")
	public Boolean createAccount(@RequestBody AccountRequestDTO dto) {
		return accountService.createAccount(dto);
	}

	@PostMapping("/login")
	public String login(@RequestBody AccountRequestDTO dto) {
		return accountService.login(dto);
	}

	@PutMapping("/changeStatus/{username}")
	public Boolean changeStatus(@PathVariable String username) {
		return accountService.changeStatus(username);
	}
}
