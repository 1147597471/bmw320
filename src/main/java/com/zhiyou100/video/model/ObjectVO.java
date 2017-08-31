package com.zhiyou100.video.model;

public class ObjectVO {
	private String name;
	private String pwd;
	private String videoTitle;
	private String speakerName;
	private String courseName;
	private int page;
	private int pageinfo;
	private String video_title;
	private String video_descr;
	private String speaker_name;
	private String course_name;
	private int video_length;
	private int video_play_times;
	private int id;
	
	public String getVideo_title() {
		return video_title;
	}
	public void setVideo_title(String video_title) {
		this.video_title = video_title;
	}
	public String getVideo_descr() {
		return video_descr;
	}
	public void setVideo_descr(String video_descr) {
		this.video_descr = video_descr;
	}
	public String getSpeaker_name() {
		return speaker_name;
	}
	public void setSpeaker_name(String speaker_name) {
		this.speaker_name = speaker_name;
	}
	public String getCourse_name() {
		return course_name;
	}
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	public int getVideo_length() {
		return video_length;
	}
	public void setVideo_length(int video_length) {
		this.video_length = video_length;
	}
	public int getVideo_play_times() {
		return video_play_times;
	}
	public void setVideo_play_times(int video_play_times) {
		this.video_play_times = video_play_times;
	}
	public int getPageinfo() {
		return pageinfo;
	}
	public void setPageinfo(int pageinfo) {
		this.pageinfo = pageinfo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getVideoTitle() {
		return videoTitle;
	}
	public void setVideoTitle(String videoTitle) {
		this.videoTitle = videoTitle;
	}
	public String getSpeakerName() {
		return speakerName;
	}
	public void setSpeakerName(String speakerName) {
		this.speakerName = speakerName;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	@Override
	public String toString() {
		return "ObjectVO [name=" + name + ", pwd=" + pwd + ", videoTitle=" + videoTitle + ", speakerName=" + speakerName
				+ ", courseName=" + courseName + ", page=" + page + ", pageinfo=" + pageinfo + ", video_title="
				+ video_title + ", video_descr=" + video_descr + ", speaker_name=" + speaker_name + ", course_name="
				+ course_name + ", video_length=" + video_length + ", video_play_times=" + video_play_times + "]";
	}
	
	
}
