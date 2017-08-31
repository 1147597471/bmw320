package com.zhiyou100.video.controller;

import java.sql.Array;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhiyou100.video.model.Course;
import com.zhiyou100.video.model.ObjectVO;
import com.zhiyou100.video.model.PlayVideo;
import com.zhiyou100.video.model.Speaker;
import com.zhiyou100.video.model.Video;
import com.zhiyou100.video.model.View;
import com.zhiyou100.video.service.CourseService;
import com.zhiyou100.video.service.SpeakerService;
import com.zhiyou100.video.service.VideoService;
import com.zhiyou100.video.utils.Page;

@Controller
@RequestMapping("admin")
public class VideoController {
	@Autowired
	VideoService vs;
	@Autowired
	SpeakerService ss;
	@Autowired
	CourseService cs;
	@RequestMapping("/video/videoList.action")
	public String videoList(@RequestParam(defaultValue="")String videoTitle,@RequestParam(defaultValue="")String speakerName, @RequestParam(defaultValue="")String courseName,@RequestParam(defaultValue="1")String page,Model md){
		
		List<Speaker> spList = ss.findAllSpeaker();
		md.addAttribute("spList",spList);
		List<Course> csList = cs.findAllCourse();
		md.addAttribute("csList",csList );
		//System.out.println("搜索数据"+videoTitle+""+speakerName+""+courseName);
		md.addAttribute("videoTitle", videoTitle);
		md.addAttribute("speakerName",speakerName );
		md.addAttribute("courseName",courseName);
		ObjectVO obj = new ObjectVO();
		obj.setVideoTitle(videoTitle);
		obj.setSpeakerName(speakerName);
		obj.setCourseName(courseName);
		obj.setPage(Integer.parseInt(page));
		Page page1 = vs.loadPage(obj);
		//System.out.println(csList);
		md.addAttribute("page", page1);
		return "forward:/WEB-INF/view/video/videoList.jsp";
		
	}
	
	@RequestMapping(value="/video/addVideo.action",method=RequestMethod.GET)
	public String addVideo(Model md){
		List<Speaker> spList = ss.findAllSpeaker();
		md.addAttribute("spList",spList);
		List<Course> csList = cs.findAllCourse();
		md.addAttribute("csList",csList );
		return "forward:/WEB-INF/view/video/addvideo.jsp";
	}
	
	@RequestMapping(value="/video/addVideo.action",method=RequestMethod.POST)
	public String addVideo(Video vd){
		vd.setInsertTime(new Timestamp(System.currentTimeMillis()));
		//System.out.println(vd);
		vs.addVideo(vd);
		return "redirect:/video/videoList.action";
	}
	
	
	@RequestMapping(value="/video/editVideo.action",method=RequestMethod.GET)
	public String editVideo(int id,Model md){
		List<Speaker> spList = ss.findAllSpeaker();
		md.addAttribute("spList",spList);
		List<Course> csList = cs.findAllCourse();
		md.addAttribute("csList",csList );
		//System.out.println(id);
		Video video = vs.findVideoById(id);
		//System.out.println(video);
		md.addAttribute("video", video);
		return "forward:/WEB-INF/view/video/editvideo.jsp";
	}
	
	@RequestMapping(value="/video/editVideo.action",method=RequestMethod.POST)
	public String editVideo(Video vd){
		vd.setUpdateTime(new Timestamp(System.currentTimeMillis()));
		//System.out.println(vd);
		//vs.addVideo(vd);
		//System.out.println(vd);
		vs.updateVideo(vd);
		return "redirect:/video/videoList.action";
	}
	
	@RequestMapping("/video/deleteVideo.action")
	public String deleteVideo(int id){
		vs.deleteVideo(id);
		return "redirect:/video/videoList.action";
	}
	
	
	@RequestMapping("/video/deleteAllVideo.action")
	public String deleteAllVideo(Integer[] brr){
		//System.out.println(Arrays.toString(brr));
	     List<Integer> list = Arrays.asList(brr);
		
		vs.deleteAllVideo(list);
		return "redirect:/video/videoList.action";
	}
	
	@RequestMapping("/video/view.action")
	public String view(){
		return "forward:/echar.jsp";
	}
	
	
	
	@RequestMapping("/video/playVideo.action")
	@ResponseBody
	public  String playVideo() throws JsonProcessingException{
		ArrayList<Video> vlist = vs.findPlayVideo();
		/*List list = new LinkedList();
		for(Video v: vlist){
			View vi = new View();
			vi.setId(v.getVideoPlayTimes());
			vi.setName(v.getCourseName());
			list.add(vi);
		}*/
		  ObjectMapper mapper = new ObjectMapper();   
		  String json = mapper.writeValueAsString(vlist); 
		 System.out.println(vlist);
		 return json;
		

	}
	
	
}
