package com.zhiyou100.video.service;

import java.util.ArrayList;
import java.util.List;

import com.zhiyou100.video.model.ObjectVO;
import com.zhiyou100.video.model.PlayVideo;
import com.zhiyou100.video.model.Video;
import com.zhiyou100.video.utils.Page;

public interface VideoService {

	Page loadPage(ObjectVO obj);

	void addVideo(Video vd);

	Video findVideoById(int id);

	void updateVideo(Video vd);

	void deleteVideo(int id);

	void deleteAllVideo(List<Integer> list);

	ArrayList<Video> findPlayVideo();

	List<Video> findVideoByCourseId(Integer id);

	List<Video> findVideoBySpeakerId(Integer id);

	

	


}
