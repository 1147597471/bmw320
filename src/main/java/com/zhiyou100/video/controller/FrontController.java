package com.zhiyou100.video.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhiyou100.video.model.Course;
import com.zhiyou100.video.model.Speaker;
import com.zhiyou100.video.model.Subject;
import com.zhiyou100.video.model.Video;
import com.zhiyou100.video.service.CourseService;
import com.zhiyou100.video.service.FrontCourseService;
import com.zhiyou100.video.service.SpeakerService;
import com.zhiyou100.video.service.SubjectService;
import com.zhiyou100.video.service.VideoService;

@Controller
public class FrontController {
	@Autowired
	FrontCourseService fcs;
	@Autowired
	CourseService cs;
	@Autowired
	VideoService vs;
	@Autowired
	SubjectService sjs;
	@Autowired
	SpeakerService ss;
	@RequestMapping("/front/course/index.action")
	public String courseIndex(int subjectId, Model md,HttpServletRequest req){
		//System.out.println(subjectId);
		List<Course> list =cs.findCourseBySubjectId(subjectId);
		for(Course cc : list){
			List<Video> videolist=vs.findVideoByCourseId(cc.getId());
			cc.setVideoList(videolist);
		}
		Subject sb=sjs.findSubjectByid(subjectId);
		md.addAttribute("courses", list);
		req.getSession().setAttribute("subjectId", subjectId);
		md.addAttribute("subject",sb);
		return "front/course/index";
	}
	
	
	@RequestMapping("/front/video/index.action")
	public String videoIndex(int videoId, int subjectId,Model md){
		Subject subject = sjs.findSubjectByid(subjectId);
		md.addAttribute("videoId", videoId);
		md.addAttribute("subject", subject);
		return "front/video/index";
	}
	
	@RequestMapping("/front/video/videoData.action")
	public String  videoData(int videoId,Model md){
		Video vd = vs.findVideoById(videoId);
		md.addAttribute("video", vd);
		Speaker speaker = ss.findSpeakerById(vd.getSpeakerId());
		md.addAttribute("speaker", speaker);
		Course course = cs.findCourseById(vd.getCourseId());
		md.addAttribute("course", course);
		List<Video> videoList = vs.findVideoBySpeakerId(speaker.getId());
		md.addAttribute("videoList", videoList);
		return "front/video/content";
	}
	
	  
	@RequestMapping("/front/video/state.action")
	public void state(int videoId){
		Video video = vs.findVideoById(videoId);
		video.setVideoPlayTimes(video.getVideoPlayTimes()+1);
		vs.updateVideo(video);
	}
	
	
}
