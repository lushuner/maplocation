package com.shawn.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shawn.entity.User;
import com.shawn.service.UserService;


/**
 * 
 * <p>Title: JsonTest</p>
 * <p>Description: json交互测试</p>
 * <p>Company: www.itcast.com</p> 
 * @author	传智.燕青
 * @date	2015-4-14下午3:54:32
 * @version 1.0
 */
@Controller
public class JsonTest {

	@Resource
	private UserService userService;

	
	//请求json串(商品信息)，输出json(商品信息)
	//@RequestBody将请求的商品信息的json串转成user对象
	//@ResponseBody将user转成json输出
	@RequestMapping("/requestJson")
	public @ResponseBody User requestJson(@RequestBody User user){
		User userTmp = userService.findUser(user.getId());
		
		//@ResponseBody将user转成json输出
		System.err.println("requestJson:"+userTmp);
		return userTmp;
	}
	
	//请求key/value，输出json
	@RequestMapping("/responseJson")
	public @ResponseBody User responseJson(HttpServletRequest request) throws Exception{
		
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println("responseJson>id:" + id);
		User user = userService.findUser(id);
		
		//@ResponseBody将user转成json输出
		System.err.println("responseJson:"+user);
		return user;
	}

}
