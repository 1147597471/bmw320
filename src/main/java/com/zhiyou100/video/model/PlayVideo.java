package com.zhiyou100.video.model;

public class PlayVideo {
	private String course_name;
	private int course_id;
	private int times;
	public String getCourse_name() {
		return course_name;
	}
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	public int getCourse_id() {
		return course_id;
	}
	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}
	public int getTimes() {
		return times;
	}
	public void setTimes(int times) {
		this.times = times;
	}
	@Override
	public String toString() {
		return "PlayVideo [course_name=" + course_name + ", course_id=" + course_id + ", times=" + times + "]";
	}
	
	
	
}
