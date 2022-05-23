package com.web.edu.third.party.service;

import java.util.List;

import com.web.edu.third.party.requestDTO.AccountRequestDTO;
import com.web.edu.third.party.responseDTO.AccountResponseDTO;

public interface AccountService {
	Boolean createAccount(AccountRequestDTO dto);

	String login(AccountRequestDTO dto);

	Boolean changeStatus(String email);

	List<AccountResponseDTO> getAllAccount();

	List<AccountResponseDTO> getAccountsByUsername(String username);
}
