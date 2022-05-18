package com.web.edu.third.party.service;

import com.web.edu.third.party.requestDTO.AccountRequestDTO;

public interface AccountService {
	Boolean createAccount(AccountRequestDTO dto);

	String login(AccountRequestDTO dto);

	Boolean changeStatus(String email);
}
