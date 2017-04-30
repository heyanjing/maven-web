package com.he.spring.base.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;

import javax.persistence.EntityManager;
import java.io.Serializable;

//JpaRepositoryFactoryBean<T extends Repository<S, ID>, S, ID extends Serializable>
public class BaseRepoFactoryBean<T extends JpaRepository<S, ID>, S, ID extends Serializable> extends JpaRepositoryFactoryBean<T, S, ID> {

    public BaseRepoFactoryBean(Class<? extends T> repositoryInterface) {
        super(repositoryInterface);
    }

    protected RepositoryFactorySupport createRepositoryFactory(EntityManager entityManager) {

        return new BaseRepoFactory(entityManager);
    }
}
