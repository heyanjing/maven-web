package com.he.spring.dao.impl;

import com.he.spring.base.dao.jdbc.BaseJdbcDao;
import com.he.spring.dao.custom.UserCustomDao;
import com.he.spring.entity.User;

public class UserDaoImpl extends BaseJdbcDao<User> implements UserCustomDao<User> {


}
