package com.web.edu.third.party.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.edu.third.party.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Integer> {
	Integer countByUsername(String username);

	Account getByUsername(String username);

	List<Account> findAccountByUsernameContainingIgnoreCase(String username);
	
	List<Account> findByUsernameIgnoreCase(String username);
}
