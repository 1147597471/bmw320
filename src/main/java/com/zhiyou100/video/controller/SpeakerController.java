package com.zhiyou100.video.controller;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.zhiyou100.video.model.Speaker;
import com.zhiyou100.video.service.SpeakerService;
import com.zhiyou100.video.utils.Page;

@Controller
@RequestMapping("admin")
public class SpeakerController {
	@Autowired
	SpeakerService ss;
	
	@RequestMapping("/speaker/speakerList.action")
	public String speakerList(@RequestParam(defaultValue="")String speakerName,@RequestParam(defaultValue="")String speakerJob,@RequestParam(defaultValue="1")Integer page,Model md){
		Speaker sp = new Speaker();
		sp.setSpeakerName(speakerName);
		sp.setSpeakerJob(speakerJob);
		sp.setPage(page);
		sp.setPageInfo((page-1)*7);
		Page page1 = ss.loadPage(sp);
		md.addAttribute("speakerName",speakerName);
		md.addAttribute("speakerJob",speakerJob);
		md.addAttribute("page", page1);
		System.out.println(page1);
		return "forward:/WEB-INF/view/speaker/speakerList.jsp";
	}
	
	
	@RequestMapping(value="/speaker/addSpeaker.action",method=RequestMethod.GET)
	public String addSpeaker(){
		return "forward:/WEB-INF/view/speaker/addSpeaker.jsp";
	}
	
	@RequestMapping(value="/speaker/addSpeaker.action",method=RequestMethod.POST)
	public String addSpeaker(Speaker sp){
		System.out.println(sp);
		sp.setInsertTime(new Timestamp(System.currentTimeMillis()));
		ss.addSpeaker(sp);
		return "redirect:/speaker/speakerList.action";
	}
	
	
	@RequestMapping(value="/speaker/editSpeaker.action",method=RequestMethod.GET)
	public String editSpeaker(int id,Model md){
		Speaker spk =ss.findSpeakerById(id);
		md.addAttribute("speaker", spk);
		return "forward:/WEB-INF/view/speaker/editSpeaker.jsp";
	}
	
	@RequestMapping(value="/speaker/editSpeaker.action",method=RequestMethod.POST)
	public String editSpeaker(Speaker sp){
		//System.out.println(sp);
		sp.setUpdateTime(new Timestamp(System.currentTimeMillis()));
		ss.editSpeaker(sp);
		return "redirect:/speaker/speakerList.action";
	}
	
	@RequestMapping("/speaker/deleteSpeaker.action")
	public String deleteVideo(int id){
		ss.deleteVideo(id);
		return "redirect:/speaker/speakerList.action";
	}
	
}
