package com.web.edu.third.party.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.edu.third.party.entity.HomeworkResult;

public interface HomeworkResultRepository extends JpaRepository<HomeworkResult, Integer> {

}
