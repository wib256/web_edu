package com.web.edu.third.party.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.edu.third.party.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
}
