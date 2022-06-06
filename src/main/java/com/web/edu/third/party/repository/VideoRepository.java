package com.web.edu.third.party.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.edu.third.party.entity.Video;

public interface VideoRepository extends JpaRepository<Video, Integer> {
	Video getVideoById(int id);

	List<Video> findByCourseLevelId(int courseLevelId);
	
	Integer countById(int id);
}
