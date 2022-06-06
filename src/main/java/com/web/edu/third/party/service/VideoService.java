package com.web.edu.third.party.service;

import java.util.List;

import com.web.edu.third.party.entity.Video;
import com.web.edu.third.party.requestDTO.VideoRequestDTO;

public interface VideoService {
	Video createVideo(VideoRequestDTO dto);

	Video getVideoById(int id);

	List<Video> getVideoByCourseLevelId(int id);

	Boolean setVideoYoutubeUrl(VideoRequestDTO dto);

	Boolean deleteVideo(int id);
}
