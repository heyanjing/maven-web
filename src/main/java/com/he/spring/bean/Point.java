package com.he.spring.bean;

import com.he.spring.base.bean.BaseBean;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Point extends BaseBean {
	private static final long	serialVersionUID	= 1L;
	private Double				lng;
	private Double				lat;
}
