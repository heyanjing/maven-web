package com.he.spring.dao;

import com.he.spring.base.dao.BaseRepo;
import com.he.spring.dao.custom.PersonCustomDao;
import com.he.spring.entity.Person;

public interface PersonDao extends BaseRepo<Person, String>,PersonCustomDao<Person> {

}
