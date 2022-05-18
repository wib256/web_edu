package com.web.edu.third.party.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.edu.third.party.entity.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {

}
