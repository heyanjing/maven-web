package com.he.spring.dao;

import com.he.spring.base.dao.repo.BaseRepo;
import com.he.spring.dao.custom.DogCustomDao;
import com.he.spring.entity.Dog;

public interface DogDao extends BaseRepo<Dog, String>, DogCustomDao<Dog> {

}
