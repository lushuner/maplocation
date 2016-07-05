package com.shawn.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.shawn.dao.LocationDao;
import com.shawn.entity.Location;

@Component
@Transactional
public class LocationService {
	
	@Resource
	private LocationDao locationDao;
	public void save(Location location){
		locationDao.save(location);
	}
	
	public List<Location> getLocations(){
		return locationDao.getLocations();
	}
}
