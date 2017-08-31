package com.zhiyou100.video.service;

import java.util.List;

import com.zhiyou100.video.model.Speaker;
import com.zhiyou100.video.utils.Page;


public interface SpeakerService {

	List<Speaker> findAllSpeaker();

	Page loadPage(Speaker sp);

	void addSpeaker(Speaker sp);

	Speaker findSpeakerById(int id);

	void editSpeaker(Speaker sp);

	void deleteVideo(int id);

}
