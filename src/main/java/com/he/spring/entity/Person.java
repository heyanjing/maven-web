package com.he.spring.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

import com.he.spring.base.entity.BaseEntityWithStringId;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "person")
@DynamicUpdate(true)
@DynamicInsert(true)
@NoArgsConstructor
public class Person extends BaseEntityWithStringId {

    @NotEmpty(message = "名字不能为空")
    private String  name;
    @Range(min = 0, max = 120, message = "年龄必须在{min}到{max}之间")
    private Integer age;
    private Date    birthday;

    public Person(String name, Integer age, Date birthday) {
        super();
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    @Transient
    private String names;

    @Transient
    public String getNames() {
        return this.name + "窝草";
    }
}
