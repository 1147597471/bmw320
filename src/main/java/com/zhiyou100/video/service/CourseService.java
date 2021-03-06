package com.zhiyou100.video.service;

import java.util.List;

import com.zhiyou100.video.model.Course;
import com.zhiyou100.video.utils.Page;



public interface CourseService {

	List<Course> findAllCourse();

	Page loadPage(int page);

	void addCourse(Course course);

	Course findCourseById(int id);

	void updateCourse(Course course);

	void deleteVideo(int id);

	List<Course> findCourseBySubjectId(int id);

}
