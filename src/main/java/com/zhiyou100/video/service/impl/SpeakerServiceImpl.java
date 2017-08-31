package com.zhiyou100.video.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.video.mapper.SpeakerMapper;
import com.zhiyou100.video.model.Speaker;
import com.zhiyou100.video.service.SpeakerService;
import com.zhiyou100.video.utils.Page;
@Service
public class SpeakerServiceImpl implements SpeakerService {
	@Autowired
	SpeakerMapper sm;
	@Override
	public List<Speaker> findAllSpeaker() {
		return sm.selectByExample(null);
	}
	@Override
	public Page loadPage(Speaker sp) {
		Page<Speaker> page = new Page<>();
		page.setPage(sp.getPage());
		page.setSize(7);
		System.out.println(sm.findCountSpeaker(sp));
		page.setTotal(sm.findCountSpeaker(sp));
		page.setRows(sm.findSpeaker(sp));
		System.out.println(sm.findSpeaker(sp));
		return page;
	}
	@Override
	public void addSpeaker(Speaker sp) {
		sm.insert(sp);
	}
	@Override
	public Speaker findSpeakerById(int id) {
		return sm.selectByPrimaryKey(id);
	}
	@Override
	public void editSpeaker(Speaker sp) {
		sm.updateByPrimaryKey(sp);
	}
	@Override
	public void deleteVideo(int id) {
		sm.deleteByPrimaryKey(id);
	}

}
