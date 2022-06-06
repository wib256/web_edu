package com.web.edu.third.party.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.edu.third.party.entity.Video;
import com.web.edu.third.party.repository.VideoRepository;
import com.web.edu.third.party.requestDTO.VideoRequestDTO;
import com.web.edu.third.party.service.VideoService;

@Service
public class VideoServiceImpl implements VideoService {
	@Autowired
	private VideoRepository videoRepository;

	@Override
	public Video createVideo(VideoRequestDTO dto) {
		try {
			Video video = new Video();
			video.setCourseLevelId(dto.getCourseLevelId());
			video.setName(dto.getName());
			video.setUrlFisebase(dto.getUrlFisebase());
			video = videoRepository.save(video);
			return video;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Video getVideoById(int id) {
		Video video = videoRepository.getVideoById(id);
		return video;
	}

	@Override
	public List<Video> getVideoByCourseLevelId(int id) {
		return videoRepository.findByCourseLevelId(id);
	}

	@Override
	public Boolean setVideoYoutubeUrl(VideoRequestDTO dto) {
		try {
			Video video = videoRepository.getById(dto.getId());
			video.setUrlYoutube(dto.getUrlYoutube());
			videoRepository.save(video);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	@Override
	public Boolean deleteVideo(int id) {
		if (videoRepository.countById(id) > 0) {
			videoRepository.deleteById(id);
			return true;
		}
		return false;
	}

}
