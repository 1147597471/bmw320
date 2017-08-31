package com.zhiyou100.video.service;

import java.util.List;

import com.zhiyou100.video.model.Admin;
import com.zhiyou100.video.model.ObjectVO;
import com.zhiyou100.video.model.User;
import com.zhiyou100.video.model.Video;

public interface AdminService {
	
	List<Admin> login(ObjectVO ov);


}
