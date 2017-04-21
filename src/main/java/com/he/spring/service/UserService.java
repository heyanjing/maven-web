package com.he.spring.service;

import com.he.spring.dao.UserDao;
import com.he.spring.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	public void save(User user){
		this.userDao.save(user);
	}
	public List<User> findByName(String name){
		return  this.userDao.findByName(name);
	}
}
