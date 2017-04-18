package com.he.spring.bean;

import com.he.spring.base.bean.BaseBean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class Qiye extends BaseBean {
	private static final long	serialVersionUID	= 1L;
	private String				id;
	private String				bgdz;
	private Point				point;

}
