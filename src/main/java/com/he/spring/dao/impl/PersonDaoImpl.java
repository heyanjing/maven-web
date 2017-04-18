package com.he.spring.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;

import com.google.common.collect.Maps;
import com.he.spring.base.dao.BaseHibernateDao;
import com.he.spring.bean.PersonBean;
import com.he.spring.dao.custom.PersonCustomDao;
import com.he.spring.entity.Person;

public class PersonDaoImpl extends BaseHibernateDao<Person> implements PersonCustomDao<Person> {

	@Override
	public Page<Person> pageByName(String name,String selectedIds, Integer pageNumber, Integer pageSize) {
		Map<String, Object> params = Maps.newHashMap();
		String sql = "SELECT * FROM person p WHERE 1=1";
		if (name != null) {
			sql += " and p.`name` like :name";
			params.put("name", "%" + name+"%");
		}
		if(selectedIds!=null){
			sql += " and p.id not in (:selectedIds)";
			params.put("selectedIds", selectedIds);
		}
		return super.pageBySql(sql, params, pageNumber, pageSize);
	}

	@Override
	public Page<PersonBean> pagePersonBeanByName(String name, Integer pageNumber, Integer pageSize) {
		Map<String, Object> params = Maps.newHashMap();
		String sql = "SELECT p.id AS id,p.age AS agex,p.birthday as birthdayx,p.`name` AS namex FROM person p WHERE 1=1";
		if (name != null) {
			sql += " and p.`name`=:name";
			params.put("name", name);
		}
		return super.pageEntityClassBySql(sql, params, PersonBean.class, pageNumber, pageSize);
	}

	@Override
	public List<Person> findAllx() {
		String sql = "SELECT p.id AS id,p.age AS age,p.birthday as birthday,p.`name` AS name FROM person p";
		return super.findBySql(sql);
	}

	@Override
	public List<PersonBean> findAllPersonBean() {
		String sql = "SELECT p.id AS id,p.age AS agex,p.birthday as birthdayx,p.`name` AS namex FROM person p";
		return super.findEntityClassBySql(sql, PersonBean.class);
	}

}
