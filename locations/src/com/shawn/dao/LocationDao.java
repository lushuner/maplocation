package com.shawn.dao;

import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.stereotype.Component;

import com.shawn.entity.Location;



@Component
public class LocationDao {

	@Resource
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void save(Location location) {
		sessionFactory.getCurrentSession().save(location);
	}

	public List<Location> getLocations() {
		Query q = sessionFactory.getCurrentSession().createQuery("from Location");
		List<Location> locations = q.list();
		return locations;
	}
	
	
}
