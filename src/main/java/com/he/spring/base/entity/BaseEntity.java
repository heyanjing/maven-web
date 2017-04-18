package com.he.spring.base.entity;

import java.io.Serializable;

import com.he.spring.base.bean.BaseBean;

@SuppressWarnings("serial")
public abstract class BaseEntity<ID extends Serializable> extends BaseBean {
    public abstract ID getId();

    public abstract void setId(ID id);
}
