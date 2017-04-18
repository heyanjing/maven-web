package com.he.spring.bean;

import java.util.Date;

import com.he.spring.base.entity.BaseEntityWithStringId;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Data
public class PersonBean extends BaseEntityWithStringId {
    private String  namex;
    private Integer agex;
    private Date    birthdayx;

    public PersonBean(String name, Integer age, Date birthday) {
        super();
        this.namex = name;
        this.agex = age;
        this.birthdayx = birthday;
    }

}
