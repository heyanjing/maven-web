package com.he.spring.dao;

import com.he.spring.base.dao.BaseRepo;
import com.he.spring.dao.custom.PersonCustomDao;
import com.he.spring.entity.Person;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PersonDao extends BaseRepo<Person, String>, PersonCustomDao<Person> {

    public Person getById(String id);

    /**
     * 写hql ,问号+数字占位
     */
    @Query("select t from Person t where t.id = ?1")
    public Person getByIdx1(String id);

    /**
     * 写sql,问号+数字占位
     */
    @Query(value = "select * from person t where t.id = ?1", nativeQuery = true)
    public Person getByIdx2(String id);

    /**
     * 写hql,占位符占位
     */
    @Query("select t from Person t where t.id = :id")
    public Person getByIdx3(@Param("id") String id);

    /**
     * 修改
     */
    @Modifying
    @Query("update Person t set t.name = ?1 where t.id = ?2")
    public Integer updateNameByIdx(String name, String id);


}
