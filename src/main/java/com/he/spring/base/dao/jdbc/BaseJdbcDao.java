package com.he.spring.base.dao.jdbc;

import com.he.spring.util.Reflections;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.JpaEntityInformationSupport;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.orm.jpa.EntityManagerFactoryInfo;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

/**
 * BaseRepositoryCustomDao 如果是多数据源的项目，则子类继承并注入不同的em 必须将注解@PersistenceContext放在set方法上，若注解在field上会报错说有多个entityManager entityManager默认名称为em
 *
 * @PersistenceContext(unitName = "em") public void setEntityManager(EntityManager entityManager) { this.entityManager = entityManager; }
 */
@Transactional
public class BaseJdbcDao<T> {
	@PersistenceContext
	protected EntityManager					entityManager;

	protected JpaEntityInformation<T, ?>	entityInformation;

	// Entity Info
	protected Class<T>						entityClass;
	protected String						entityName;
	protected String						entityIdName;

	// Data Info
	protected DataSource   dataSource;
	protected JdbcTemplate jdbcTemplate;

	@PostConstruct
	public void postConstruct() {
		// Entity Info
		this.entityClass = Reflections.getClassGenricType(getClass());
		this.entityInformation = JpaEntityInformationSupport.getEntityInformation(entityClass, entityManager);
		this.entityName = this.entityInformation.getEntityName();
		this.entityIdName = this.entityInformation.getIdAttributeNames().iterator().next();

		// Data Info
		this.dataSource = getEntityManagerFactoryInfo().getDataSource();
		this.jdbcTemplate = new JdbcTemplate(this.dataSource);
	}

	protected EntityManager getEntityManager() {
		return this.entityManager;
	}

	private EntityManagerFactoryInfo getEntityManagerFactoryInfo() {
		return (EntityManagerFactoryInfo) this.entityManager.getEntityManagerFactory();
	}

	protected DataSource getDataSource() {
		return this.dataSource;
	}

	protected JdbcTemplate getJdbcTemplate() {
		return this.jdbcTemplate;
	}

	/**
	 * 获取实体类型
	 */
	protected Class<T> getEntityClass() {
		return this.entityClass;
	}

	/**
	 * 获取实体名称
	 */
	protected String getEntityName() {
		return this.entityName;
	}

	/*----------------------------------------------------------------------------------------
	|            find/page by sql
	========================================================================================*/
	public List<T> findBySql(String sql) {
		return getJdbcTemplate().find(sql, this.entityClass);
	}

	public List<T> findBySql(String sql, Map<String, ?> params) {
		return getJdbcTemplate().find(sql, this.entityClass, params);
	}

	public List<T> findBySql(String sql, Object... params) {
		return getJdbcTemplate().find(sql, this.entityClass, params);
	}

	public Page<T> pageBySql(String sql, int pageNumber, int pageSize) {
		return getJdbcTemplate().page(sql, this.entityClass, pageNumber, pageSize);
	}

	public Page<T> pageBySql(String sql, int pageNumber, int pageSize, Map<String, ?> params) {
		return getJdbcTemplate().page(sql, this.entityClass, pageNumber, pageSize, params);
	}

	public Page<T> pageBySql(String sql, int pageNumber, int pageSize, Object... params) {
		return getJdbcTemplate().page(sql, this.entityClass, pageNumber, pageSize, params);
	}

	/*----------------------------------------------------------------------------------------
	|            find/page by sql and entityClass
	========================================================================================*/
	public <E> List<E> findBySql(String sql, Class<E> entityClass) {
		return getJdbcTemplate().find(sql, entityClass);
	}

	public <E> List<E> findBySql(String sql, Class<E> entityClass, Map<String, ?> params) {
		return getJdbcTemplate().find(sql, entityClass, params);
	}

	public <E> List<E> findBySql(String sql, Class<E> entityClass, Object... params) {
		return getJdbcTemplate().find(sql, entityClass, params);
	}

	public <E> Page<E> pageBySql(String sql, Class<E> entityClass, int pageNumber, int pageSize) {
		return getJdbcTemplate().page(sql, entityClass, pageNumber, pageSize);
	}

	public <E> Page<E> pageBySql(String sql, Class<E> entityClass, int pageNumber, int pageSize, Map<String, ?> params) {
		return getJdbcTemplate().page(sql, entityClass, pageNumber, pageSize, params);
	}

	public <E> Page<E> pageBySql(String sql, Class<E> entityClass, int pageNumber, int pageSize, Object... params) {
		return getJdbcTemplate().page(sql, entityClass, pageNumber, pageSize, params);
	}

	/*----------------------------------------------------------------------------------------
	|            find/page by sql and RowMapper
	========================================================================================*/
	public <E> List<E> findBySql(String sql, RowMapper<E> mapper) {
		return getJdbcTemplate().find(sql, mapper);
	}

	public <E> List<E> findBySql(String sql, RowMapper<E> mapper, Map<String, ?> params) {
		return getJdbcTemplate().find(sql, mapper, params);
	}

	public <E> List<E> findBySql(String sql, RowMapper<E> mapper, Object... params) {
		return getJdbcTemplate().find(sql, mapper, params);
	}

	public <E> Page<E> pageBySql(String sql, RowMapper<E> mapper, int pageNumber, int pageSize) {
		return getJdbcTemplate().page(sql, mapper, pageNumber, pageSize);
	}

	public <E> Page<E> pageBySql(String sql, RowMapper<E> mapper, int pageNumber, int pageSize, Map<String, ?> params) {
		return getJdbcTemplate().page(sql, mapper, pageNumber, pageSize, params);
	}

	public <E> Page<E> pageBySql(String sql, RowMapper<E> mapper, int pageNumber, int pageSize, Object... params) {
		return getJdbcTemplate().page(sql, mapper, pageNumber, pageSize, params);
	}

}
