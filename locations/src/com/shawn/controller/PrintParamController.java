package com.shawn.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PrintParamController {

	@RequestMapping("/printParam")
	public ModelAndView printParam(HttpServletRequest request,Integer id,String name){
		
		System.out.println("request.getParameter('id'):"+request.getParameter("id"));
		System.out.println("request.getParameter('name'):"+request.getParameter("name"));
		System.out.println("Integer id="+id);
		System.out.println("String name="+name);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("user","username:"+request.getParameter("name")+"\nid:"+request.getParameter("id"));
		mv.setViewName("printParam");
		
		return mv;
	}
}
