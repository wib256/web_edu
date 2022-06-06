package com.web.edu.third.party.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.edu.third.party.entity.Video;
import com.web.edu.third.party.requestDTO.VideoRequestDTO;
import com.web.edu.third.party.service.VideoService;

@RestController
@RequestMapping("/api/video")
public class VideoController {
	@Autowired
	private VideoService videoService;

	@PostMapping("/createVideo")
	public Video createVideo(@RequestBody VideoRequestDTO dto) {
		return videoService.createVideo(dto);
	}

	@GetMapping("/getVideoById/{id}")
	public Video getVideoById(@PathVariable int id) {
		return videoService.getVideoById(id);
	}

	@GetMapping("/getVideosByCourseLevelId/{id}")
	public List<Video> getVideosByCourseLevelId(@PathVariable int id) {
		return videoService.getVideoByCourseLevelId(id);
	}

	@PutMapping("/editYoutubeUrl")
	public Boolean editYoutubeUrl(@RequestBody VideoRequestDTO dto) {
		return videoService.setVideoYoutubeUrl(dto);
	}

	@DeleteMapping("/deleteVideo/{id}")
	public Boolean deleteVideo(@PathVariable int id) {
		return videoService.deleteVideo(id);
	}
}
