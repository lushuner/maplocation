package com.shawn.test;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shawn.entity.Location;
import com.shawn.entity.User;
import com.shawn.service.LocationService;
import com.shawn.service.UserService;



public class App {
	
	private ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");

	@Test
	public void testSavaUser() throws Exception{
		UserService userService = (UserService)ac.getBean("userService");
		User user = new User();
		user.setName("蔓蔓22");
		user.setPassword("123");
		userService.save(user);
	}

	@Test
	public void testFindUser(){
		UserService userService = (UserService)ac.getBean("userService");
	
		User user = new UserService().findUser(1, "123");
		if(user!=null)
			System.out.println(user.toString());
		else
			System.out.println("null");
	}
	
	@Test
	public void testSaveLocation(){
		LocationService service = (LocationService) ac.getBean("locationService");
		Location location = new Location();
		location.setDirection(64.23);
		location.setLatitude(29.57672);
		location.setLongitude(106.472977);
		location.setSpeed(0);
		location.setDate(new Date());
		service.save(location);
	}
	@Test
	public void testGetLocations(){
		LocationService service = (LocationService) ac.getBean("locationService");
		List<Location> locations = service.getLocations();
		System.err.println("locations.size()=" + locations.size());
		for(Location location : locations)
			System.out.println(location);
		
	}
}
