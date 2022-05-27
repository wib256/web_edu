package com.web.edu.third.party.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.web.edu.third.party.constant.Constant;
import com.web.edu.third.party.entity.Account;
import com.web.edu.third.party.entity.Admin;
import com.web.edu.third.party.entity.Student;
import com.web.edu.third.party.entity.Teacher;
import com.web.edu.third.party.exception.AccountException;
import com.web.edu.third.party.repository.AccountRepository;
import com.web.edu.third.party.repository.AdminRepository;
import com.web.edu.third.party.repository.StudentRepository;
import com.web.edu.third.party.repository.TeacherRepository;
import com.web.edu.third.party.requestDTO.AccountRequestDTO;
import com.web.edu.third.party.responseDTO.AccountResponseDTO;
import com.web.edu.third.party.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private AdminRepository adminRepository;

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private TeacherRepository teacherRepository;

	@Override
	public Boolean createAccount(AccountRequestDTO dto) {
		if (accountRepository.countByUsername(dto.getEmail()) == 0) {
			Account account = new Account();
			account.setUsername(dto.getEmail());
			account.setPassword(dto.getPassword());
			account.setPhone(dto.getPhone());
			switch (dto.getRole()) {
			case 1:
				account.setRoleId(Constant.ADMIN_ROLE);
				Admin admin = new Admin();
				admin.setName(dto.getFullname());
				admin.setUsername(dto.getEmail());
				adminRepository.save(admin);
				break;
			case 2:
				account.setRoleId(Constant.STUDENT_ROLE);
				Student student = new Student();
				student.setName(dto.getFullname());
				student.setUsername(dto.getEmail());
				studentRepository.save(student);
				break;
			case 3:
				account.setRoleId(Constant.TEACHER_ROLE);
				Teacher teacher = new Teacher();
				teacher.setName(dto.getFullname());
				teacher.setUsername(dto.getEmail());
				teacherRepository.save(teacher);
				break;
			default:
				break;
			}
			account.setStatus(Constant.ACTIVE);
			accountRepository.save(account);
			return true;
		} else {
			throw new AccountException(Constant.EXCIST_ACCOUNT);
		}
	}

	@Override
	public String login(AccountRequestDTO dto) {
		if (accountRepository.countByUsername(dto.getEmail()) == 0) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, Constant.NOT_FOUND_USERNAME);
		} else {
			Account account = accountRepository.findByUsername(dto.getEmail());
			if (account != null) {
				if (account.getPassword().compareTo(dto.getPassword()) == 0) {
					if (account.getStatus().compareTo(Constant.ACTIVE) == 0) {
						return account.getRoleId();
					} else {
						throw new ResponseStatusException(HttpStatus.CONFLICT, Constant.DEACTIVE_ACCOUNT);
					}

				} else {
					throw new ResponseStatusException(HttpStatus.CONFLICT, Constant.ERROR_PASSWORD);
				}
			} else {
				throw new ResponseStatusException(HttpStatus.CONFLICT, Constant.ERROR_PASSWORD);
			}
		}
	}

	@Override
	public Boolean changeStatus(String email) {
		if (accountRepository.countByUsername(email) == 0) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, Constant.NOT_FOUND_USERNAME);
		} else {
			Account account = accountRepository.findByUsername(email);
			if (account.getStatus().compareTo(Constant.ACTIVE) == 0) {
				account.setStatus(Constant.DEACTIVE);
			} else {
				account.setStatus(Constant.ACTIVE);
			}
			accountRepository.save(account);
			return true;
		}
	}

	@Override
	public List<AccountResponseDTO> getAllAccount() {
		List<Account> accounts = new ArrayList<Account>();
		List<AccountResponseDTO> accountResponseDTOs = new ArrayList<AccountResponseDTO>();
		accounts = accountRepository.findAll();
		if (!accounts.isEmpty()) {
			for (Account account : accounts) {
				AccountResponseDTO accountResponseDTO = new AccountResponseDTO();
				accountResponseDTO.setEmail(account.getUsername());
				accountResponseDTO.setStatus(account.getStatus());
				accountResponseDTO.setRole(account.getRoleId());
				accountResponseDTO.setPhone(account.getPhone());
				accountResponseDTOs.add(accountResponseDTO);
			}
			return accountResponseDTOs;
		}
		return accountResponseDTOs;
	}

	@Override
	public List<AccountResponseDTO> getAccountsByUsername(String username) {
		List<Account> accounts = new ArrayList<Account>();
		List<AccountResponseDTO> accountResponseDTOs = new ArrayList<AccountResponseDTO>();
		accounts = accountRepository.findAccountByUsernameContainingIgnoreCase(username);
		if (!accounts.isEmpty()) {
			for (Account account : accounts) {
				AccountResponseDTO accountResponseDTO = new AccountResponseDTO();
				accountResponseDTO.setEmail(account.getUsername());
				accountResponseDTO.setStatus(account.getStatus());
				accountResponseDTO.setRole(account.getRoleId());
				accountResponseDTO.setPhone(account.getPhone());
				accountResponseDTOs.add(accountResponseDTO);
			}
			return accountResponseDTOs;
		}
		return accountResponseDTOs;

	}

}
