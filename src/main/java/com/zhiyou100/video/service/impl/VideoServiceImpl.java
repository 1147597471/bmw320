package com.zhiyou100.video.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.video.mapper.VideoMapper;
import com.zhiyou100.video.model.ObjectVO;
import com.zhiyou100.video.model.PlayVideo;
import com.zhiyou100.video.model.Video;
import com.zhiyou100.video.model.VideoExample;
import com.zhiyou100.video.service.VideoService;
import com.zhiyou100.video.utils.Page;
@Service
public class VideoServiceImpl implements VideoService {
	@Autowired
	VideoMapper vm;
	@Override
	public Page loadPage(ObjectVO obj) {
		Page<Video> page1 = new Page();
		page1.setSize(7);
		int number = vm.selectCountVideo(obj);
		//System.out.println(number);
		page1.setTotal(vm.selectCountVideo(obj));
		page1.setPage(obj.getPage());
		obj.setPageinfo((obj.getPage()-1)*7);
		page1.setRows(vm.selectAllVideo(obj));
		List<Video> list = vm.selectAllVideo(obj);
		//System.out.println("list-------------------------------"+list);
		return page1;
	}
	@Override
	public void addVideo(Video vd) {
		vm.insert(vd);
		
	}
	@Override
	public Video findVideoById(int id) {
		
		return vm.selectByPrimaryKey(id);
	}
	@Override
	public void updateVideo(Video vd) {
		vm.updateByPrimaryKeySelective(vd);
		
	}
	@Override
	public void deleteVideo(int id) {
		vm.deleteByPrimaryKey(id);
		
	}
	
	@Override
	public void deleteAllVideo(List<Integer> list) {
			VideoExample ex = new VideoExample();
			ex.createCriteria().andIdIn(list);
			vm.deleteByExample(ex);
	}
	@Override
	public ArrayList<Video> findPlayVideo() {
		
		return vm.findPlayVideo();
	}
	@Override
	public List<Video> findVideoByCourseId(Integer id) {
		VideoExample ex = new VideoExample();
		ex.createCriteria().andCourseIdEqualTo(id);
		return vm.selectByExample(ex);
	}
	@Override
	public List<Video> findVideoBySpeakerId(Integer id) {
		VideoExample ex = new VideoExample();
		ex.createCriteria().andSpeakerIdEqualTo(id);
		return vm.selectByExample(ex);
	}
	
	
	
	
	
}
