package com.he.spring.dao;

import com.he.spring.base.dao.BaseRepo;
import com.he.spring.dao.custom.UserCustomDao;
import com.he.spring.entity.User;

import java.util.List;

public interface UserDao extends BaseRepo<User, String>, UserCustomDao<User> {

    List<User> findByName(String name);

    User getById(String id);
}
