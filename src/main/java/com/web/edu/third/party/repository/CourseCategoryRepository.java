package com.web.edu.third.party.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.edu.third.party.entity.CourseCategory;

public interface CourseCategoryRepository extends JpaRepository<CourseCategory, Integer> {

}
