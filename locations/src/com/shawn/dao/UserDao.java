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

import com.shawn.entity.User;


@Component
public class UserDao {

	@Resource
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void save(User user) {
		sessionFactory.getCurrentSession().save(user);
	}

	public User findUser(int id) {
		User user = (User) sessionFactory.getCurrentSession().get(User.class, id);
		return user;
	}

	public User findUser(int id, String password) {
		Session session = sessionFactory.getCurrentSession();
		Query q = session.createQuery("from User where id = ? and password = ?");
		q.setInteger(0, id);
		q.setString(1, password);
		List<User> list = q.list();
		User user = null;
		if (list.size()>0) {
			user = list.get(0);
		}
		return user;
	}
	
	
}
