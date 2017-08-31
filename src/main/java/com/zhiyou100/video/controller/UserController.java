package com.zhiyou100.video.controller;

import java.io.File;
import java.util.Enumeration;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import javax.mail.Session;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.zhiyou100.video.model.User;
import com.zhiyou100.video.service.UserService;
import com.zhiyou100.video.utils.RandomStr;

@Controller
public class UserController {
	@Autowired
	UserService us;
	
	
	@RequestMapping("/front/index.action")
	public String front(){
		return "redirect:/index.jsp"; 
	}
	
	
	
	@RequestMapping("/front/user/regist.action")
	@ResponseBody
	public String regist(User u){
		//System.out.println(u);
		List<User> ulist = us.findExistUser(u);
		
		if(ulist.size()==0){
			us.registUser(u);
			
			return "success";
		}
		else	
		     return "false"; 
	}
	
	
	
	
	@RequestMapping("/front/user/login.action")
	@ResponseBody
	public String login(User u,HttpServletRequest req){
		  //System.out.println(u);
		  List<User> list = us.findExistUser(u);
		  User user=null;
		  
		  if(list.size()!=0){
			  for(User uu : list){
				  user=uu;
				  break;
			  }
			  req.getSession().setAttribute("_front_user",user);
			  req.getSession().setAttribute("user",user);
			  return "success";
		  }else{
			  
			  return "false"; 
		  }
	}
	
	
	@RequestMapping("/front/user/logout.action")
	public String exit(HttpServletRequest req){
		   req.getSession().removeAttribute("_front_user");
   	  		return "redirect:/front/index.action"; 
	}
	
	
	@RequestMapping("/front/user/index.action")
	public String userIndex(){
		return  "front/user/index";
	}
	
	@RequestMapping(value="/front/user/profile.action",method=RequestMethod.GET)
	public String editUser(){
		return  "front/user/profile";
	}
	
	@RequestMapping(value="/front/user/profile.action",method=RequestMethod.POST)
	public String editUser(User u,HttpServletRequest req){
		//System.out.println(u);
		us.updateUser(u);
		User user=us.findUserById(u);
		//System.out.println(user);     
		req.getSession().setAttribute("user", user);
		return  "redirect:/front/user/index.action";   
		
	}
	
	@RequestMapping(value="/front/user/avatar.action",method=RequestMethod.GET)
	public String avatarUser(){
		return  "front/user/avatar";
	}
	
	@RequestMapping(value="/front/user/avatar.action",method=RequestMethod.POST)
	public String updateRole1(User u,MultipartFile image_file,HttpServletRequest req) throws Exception{
		String str =UUID.randomUUID().toString().replaceAll("-", "");
		//System.out.println(pic.getOriginalFilename());//输出1.gif
		String ext = FilenameUtils.getExtension(image_file.getOriginalFilename());//获得gif
		//System.out.println("ext="+ext);
		String fileName = str+"."+ext;
		u.setHeadUrl(fileName);
		//System.out.println(u);
	    us.updateImg(u);
		//System.out.println(fileName);
		String path ="D:\\upload";
		image_file.transferTo(new File(path+"\\"+fileName));
		User user=us.findUserById(u);
		req.getSession().setAttribute("user", user);
		return "redirect:/front/user/index.action";
		
	}
	
	
	@RequestMapping(value="/front/user/password.action",method=RequestMethod.GET)
	public String password(){
		return  "front/user/password";
	}
	
	@RequestMapping(value="/front/user/password.action",method=RequestMethod.POST)
	@ResponseBody
	public String password(String oldPassword,String newPassword,int id){
		//System.out.println(oldPassword+"---"+newPassword+"---"+id);
		User user = new User();
		user.setPassword(oldPassword);
		user.setId(id);
		//System.out.println(user);
		List<User> list = us.findUserByPassWord(user);
		if(list.size()!=0){
			//System.out.println("true");
			user.setPassword(newPassword);
			us.updateUser(user);
			return "success";
		}else{
			return  "false";
		}
		
	}
	
	
	@RequestMapping("/front/forgetpwd1.action")
	public String forgetpwd(){
		return "front/user/forget_pwd";
	}
	
	@RequestMapping("/front/sendemail.action")
	@ResponseBody
	public String sendemail(String email){
		User user = new User();
		
		String str=RandomStr.getRandom(5);
		
		user.setEmail(email);
		user.setCaptcha(str);
		//System.out.println(email);
		//System.out.println(user);
		List<User> list =us.findEmail(user);
		if(list.size()!=0){
			us.updateUserByCaptcha(user);
			return "success";
		}
		return "false";
	}
	
	@RequestMapping("/front/forgetpwd.action")
	public String forgetPwd(User u,Model md){
		//System.out.println(u);
		List<User> list = us.findUserByEamilAndCaptcha(u);
		if(list.size()!=0){
			md.addAttribute("email",u.getEmail());
			md.addAttribute("captcha", u.getCaptcha());
			return "front/user/reset_pwd";
		}
		return "front/user/forget_pwd";
	}
	
	@RequestMapping("/front/resetpwd.action")
	@ResponseBody
	public String resetPwd(User u){
		System.out.println(u);
		us.updateUserPwd(u);
		return "success";
	}
	
	
	@RequestMapping("/front/chenkemail.action")
	@ResponseBody
	public String checkemail(String email){
		//System.out.println(email);
		User user = new User();
		user.setEmail(email);
		List<User> list = us.findEmail(user);
		if(list.size()==0){
			return "true";
		}
		return "false";
	}
	
}
