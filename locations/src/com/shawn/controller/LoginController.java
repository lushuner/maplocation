package com.shawn.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.shawn.entity.User;
import com.shawn.service.UserService;

@Controller
public class LoginController {

	@Resource
	private UserService userService;
	
	@RequestMapping("/loginCheck")
	public ModelAndView loginCheck(HttpServletRequest request){
		
		User user = userService.findUser(Integer.parseInt(request.getParameter("id")),request.getParameter("password"));
		ModelAndView mv = new ModelAndView();
		if(user!=null){
			mv.addObject("user",user);
			mv.setViewName("location");
		}else{
			mv.setViewName("index");
		}
		return mv;
	}
	@RequestMapping("/regist")
	public ModelAndView regist(HttpServletRequest request){
		
		User user = new User();
		user.setName(request.getParameter("name"));
		user.setPassword(request.getParameter("password"));
		userService.save(user);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("user","username:"+request.getParameter("name")+"\n</br>password:"+request.getParameter("password"));
		mv.setViewName("success");
		return mv;
	}
/*	@RequestMapping("/loginCheck")
	public void loginCheck(HttpServletRequest request,HttpServletResponse response) throws Exception{
		
		User user = userService.findUser(Integer.parseInt(request.getParameter("id")),request.getParameter("password"));
		if(user!=null){
			request.getRequestDispatcher("location.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}*/
	

		
	
}
