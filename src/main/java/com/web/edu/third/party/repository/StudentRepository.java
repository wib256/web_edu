package com.web.edu.third.party.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.edu.third.party.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
