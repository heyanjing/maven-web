package com.he.spring.service;

import com.he.spring.bean.PersonBean;
import com.he.spring.dao.DogDao;
import com.he.spring.dao.PersonDao;
import com.he.spring.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

	@Autowired
	private PersonDao	personDao;
	@Autowired
	private DogDao		dogDao;

	public Person save(Person person) {
		Person p = personDao.save(person);
		//Dog d = new Dog("d1", 1, new Date());
		//this.dogDao.save(d);
		// if (true) {
		// throw new RuntimeException();// 默认运行时异常回滚
		// // throw new Exception();//编译时异常不回滚
		// }
		return p;
	}

	public List<Person> saveAll(List<Person> persons) {
		return this.personDao.save(persons);
	}

	public Person get(String id) {
		Person p3 = personDao.get(id);
		return p3;
	}

	public List<Person> findAll() {
		// return personDao.findAll();
		return this.personDao.findAllx();
	}

	public List<Person> findAllx() {
		this.xx();
		// return personDao.findAll();
		return this.personDao.findAllx();
	}

	public void xx() {
		System.err.println("xxxxxxxxxxxxxxxxx");
		// System.err.println("00000000000000000");
	}

	public List<PersonBean> findAllPersonBean() {
		return this.personDao.findAllPersonBean();
	}

	public long getCount() {
		return this.personDao.count();
	}

	public Page<Person> pageByName(String name,String selectedIds, Integer pageNumber, Integer pageSize) {
		return this.personDao.pageByName(name,selectedIds, pageNumber, pageSize);
	}

	public Page<PersonBean> pagePersonBeanByName(String name, Integer pageNumber, Integer pageSize) {
		return this.personDao.pagePersonBeanByName(name, pageNumber, pageSize);
	}
}
