package com.shawn.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.shawn.dao.UserDao;
import com.shawn.entity.User;


@Component
@Transactional
public class UserService {
	
	@Resource
	private UserDao userDao;
	public void setDeptDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public void save(User user){
		userDao.save(user);
	}
	
	public User findUser(int id){
		return userDao.findUser(id);
	}
	
	public User findUser(int id,String password){
		return userDao.findUser(id,password);
	}
}
