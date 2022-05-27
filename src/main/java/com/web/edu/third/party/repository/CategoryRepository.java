package com.web.edu.third.party.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.edu.third.party.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
	Integer countByName(String name);
}
