package com.he.spring.bean;

import com.he.spring.base.bean.BaseBean;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class GeocodingResult extends BaseBean {
	private static final long	serialVersionUID	= 1L;
	private Integer				status;
	private SubResult			result;
}
