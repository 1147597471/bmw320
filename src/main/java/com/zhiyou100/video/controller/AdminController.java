package com.zhiyou100.video.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhiyou100.video.model.Admin;
import com.zhiyou100.video.model.ObjectVO;
import com.zhiyou100.video.model.User;
import com.zhiyou100.video.model.Video;
import com.zhiyou100.video.service.AdminService;
@Controller
public class AdminController {
	@Autowired
	AdminService as;
	
	@RequestMapping("/admin/login.action")
	public String login(ObjectVO ov,HttpServletRequest req){
		String pwd = ov.getPwd();
		ov.setPwd(DigestUtils.md5DigestAsHex(pwd.getBytes()));
		//System.out.println(ov);
		List<Admin> list = as.login(ov);
		//System.out.println(list);
		req.getSession().setAttribute("loginList",list);
		return "redirect:/admin/video/videoList.action";                                                 
	}
	
	@RequestMapping("/admin/index.action")
	public String adminIndex(){
		return "/index";
	}
}
