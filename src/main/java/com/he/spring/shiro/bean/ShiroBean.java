package com.he.spring.shiro.bean;

import com.he.spring.base.bean.BaseBean;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 封装ShiroRealm登录认证后的相关信息
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ShiroBean extends BaseBean {
    private String  name;
    private String  md5Password;
    private String  sha1Password;
    private String  salt;
    private Integer state;

}
