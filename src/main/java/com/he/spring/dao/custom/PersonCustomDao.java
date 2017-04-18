package com.he.spring.dao.custom;

import java.util.List;

import org.springframework.data.domain.Page;

import com.he.spring.bean.PersonBean;

public interface PersonCustomDao<Person> {

    public Page<Person> pageByName(String name, String selectedIds, Integer pageNumber, Integer pageSize);

    public Page<PersonBean> pagePersonBeanByName(String name, Integer pageNumber, Integer pageSize);

    public List<Person> findAllx();

    public List<PersonBean> findAllPersonBean();

}
