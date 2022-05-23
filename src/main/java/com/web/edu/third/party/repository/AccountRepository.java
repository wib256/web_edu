package com.web.edu.third.party.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.edu.third.party.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Integer> {
	Integer countByUsername(String username);

	Account findByUsername(String username);

	List<Account> findByUsernameContainingIgnoreCase(String username);
}
