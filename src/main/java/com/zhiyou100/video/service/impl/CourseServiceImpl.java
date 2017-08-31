package com.zhiyou100.video.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.video.mapper.CourseMapper;
import com.zhiyou100.video.model.Course;
import com.zhiyou100.video.model.CourseExample;
import com.zhiyou100.video.service.CourseService;
import com.zhiyou100.video.utils.Page;
@Service
public class CourseServiceImpl implements CourseService {
	@Autowired
	CourseMapper cm;
	@Override
	public List<Course> findAllCourse() {
		return cm.selectByExample(null);
	}
	@Override
	public Page loadPage(int page) {
		Page<Course> page1 = new Page();
		page1.setPage(page);
		page1.setSize(7);
		
		page1.setTotal(cm.findAllCountCourse());
		page1.setRows(cm.findAllCourse((page-1)*7));
		//System.out.println(cm.findAllCountCourse());
		//System.out.println(cm.findAllCourse((page-1)*7));		
		return page1;
	}
	@Override
	public void addCourse(Course course) {
		cm.insert(course);
	}
	@Override
	public Course findCourseById(int id) {
		return cm.selectByPrimaryKey(id);
	}
	@Override
	public void updateCourse(Course course) {
		cm.updateByPrimaryKey(course);
	}
	@Override
	public void deleteVideo(int id) {
		cm.deleteByPrimaryKey(id);
	}
	@Override
	public List<Course> findCourseBySubjectId(int id) {
		CourseExample ex = new CourseExample();
		ex.createCriteria().andSubjectIdEqualTo(id);
		return cm.selectByExample(ex);
	}
	
}
