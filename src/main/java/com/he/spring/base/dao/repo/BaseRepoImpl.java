package com.he.spring.base.dao.repo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import com.he.spring.base.dao.jdbc.JdbcTemplate;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.JpaEntityInformationSupport;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.orm.jpa.EntityManagerFactoryInfo;

public class BaseRepoImpl<T, ID extends Serializable> extends SimpleJpaRepository<T, ID> implements BaseRepo<T, ID> {
	private final EntityManager	em;
	private final Class<T>		entityClass;
	private final String		entityName;

	protected DataSource   dataSource;
	protected JdbcTemplate jdbcTemplate;



	public BaseRepoImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
		super(entityInformation, entityManager);
		this.em = entityManager;
		this.entityClass = entityInformation.getJavaType();
		this.entityName = entityInformation.getEntityName();

		this.dataSource = ((EntityManagerFactoryInfo) entityManager.getEntityManagerFactory()).getDataSource();
		this.jdbcTemplate = new JdbcTemplate(this.dataSource);
	}

	public BaseRepoImpl(Class<T> domainClass, EntityManager em) {
		this(JpaEntityInformationSupport.getEntityInformation(domainClass, em), em);
	}

	@Override
	public T get(ID id) {
		System.out.println(em);
		System.out.println(entityClass);
		System.out.println(entityName);
		return super.findOne(id);
	}

	@Override
	public JdbcTemplate getJdbcTemplate() {
		return this.jdbcTemplate;
	}

	@Override
	public List<T> find(String sql, Map<String, ?> params) {
		return this.jdbcTemplate.find(sql, this.entityClass, params);
	}
}
