package com.zhiyou100.video.controller;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.zhiyou100.video.model.Course;
import com.zhiyou100.video.model.ObjectVO;
import com.zhiyou100.video.model.Speaker;
import com.zhiyou100.video.model.Subject;
import com.zhiyou100.video.service.CourseService;
import com.zhiyou100.video.service.SpeakerService;
import com.zhiyou100.video.service.SubjectService;
import com.zhiyou100.video.service.VideoService;
import com.zhiyou100.video.utils.Page;

@Controller
@RequestMapping("admin")
public class CourseController {
	@Autowired
	VideoService vs;
	@Autowired
	SpeakerService ss;
	@Autowired
	CourseService cs;
	@Autowired
	SubjectService sj;
	@RequestMapping("/course/courseList.action")
	public String videoList(@RequestParam(defaultValue="1")Integer page,Model md){
		
		Page page1 = cs.loadPage(page);
		//System.out.println(csList);
		md.addAttribute("page", page1);
		return "forward:/WEB-INF/view/course/courseList.jsp";
		
	}
	
	@RequestMapping(value="/course/addCourse.action",method=RequestMethod.GET)
	public String addCourse(Model md){
		List<Subject> sjList = sj.findAllSuject();
		md.addAttribute("sjList", sjList);
		return "forward:/WEB-INF/view/course/addCourse.jsp";
	}
	
	@RequestMapping(value="/course/addCourse.action",method=RequestMethod.POST)
	public String addCourse(Course course){
		//System.out.println(course);
		course.setInsertTime(new Timestamp(System.currentTimeMillis()));
		cs.addCourse(course);
		return "redirect:/course/courseList.action";
	}
	
	
	@RequestMapping(value="/course/editCourse.action",method=RequestMethod.GET)
	public String editCourse(int id,Model md){
		List<Subject> sjList = sj.findAllSuject();
		md.addAttribute("sjList", sjList);
		Course course = cs.findCourseById(id);
		md.addAttribute("course", course);
		return "forward:/WEB-INF/view/course/editCourse.jsp";
	}
	
	@RequestMapping(value="/course/editCourse.action",method=RequestMethod.POST)
	public String editCourse(Course course){
		System.out.println(course);
		course.setUpdateTime(new Timestamp(System.currentTimeMillis()));
		cs.updateCourse(course);
		return "redirect:/course/courseList.action";
	}
	
	@RequestMapping("/course/deleteCourse.action")
	public String deleteVideo(int id){
		cs.deleteVideo(id);
		return "redirect:/course/courseList.action";
	}
	
}
