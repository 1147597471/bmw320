package com.zhiyou100.video.controller;

import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.zhiyou100.video.model.Admin;


public class CustomInterceptor implements HandlerInterceptor {
	
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {

	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {

	}

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object controller) throws Exception {
		List<Admin> tlist = (List<Admin>) req.getSession().getAttribute("loginList");
		if(req.getServletPath().equals("/admin/login.action")){
			return true;
		}
		if(tlist!=null){
			
			/*if(tlist.size()!=0){
				return true;
			}else{
				res.sendRedirect(req.getContextPath()+"/index.jsp");
				return false;
			}*/
			return true;
		}else{
			req.getRequestDispatcher("/WEB-INF/view/index.jsp").forward(req, res);;
			return false;
		}
		
	}

}
