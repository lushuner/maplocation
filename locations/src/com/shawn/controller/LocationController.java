package com.shawn.controller;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.shawn.entity.Location;
import com.shawn.service.LocationService;


@Controller
public class LocationController {
	@Resource
	private LocationService locationService;
	@RequestMapping("/uploadLocation")
	public @ResponseBody Location uploadLocation(@RequestBody Location location){
		location.setDate(new Date());
		locationService.save(location);
		return location;
	}
	
	@RequestMapping("/downloadLocations")
	public @ResponseBody List<Location> downloadLocations(HttpSession session) throws Exception{
		List<Location> locations = locationService.getLocations();
		session.setAttribute("locations", locations);
		
		return locations;
	}

	@RequestMapping("test")
	public void showParam(HttpServletRequest request){
		System.out.println(request.getParameter("name"));
	}
	
	@RequestMapping("/showLocations")
	public @ResponseBody Map<String,List<Location>> showLocations(){
		Map<String,List<Location>> map = new HashMap<String, List<Location>>();
		String key = "LocationInfo";
		List<Location> locations = locationService.getLocations();
		map.put(key, locations);
		return map;
	}
}
