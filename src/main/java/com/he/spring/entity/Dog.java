package com.he.spring.entity;

import com.he.spring.base.entity.BaseEntityWithStringId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@SuppressWarnings("serial")
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "dog")
@DynamicUpdate(true)
@DynamicInsert(true)
@NoArgsConstructor
public class Dog extends BaseEntityWithStringId {
    private String  name;
    private Integer age;
    private Date    birthday;

    public Dog(String name, Integer age, Date birthday) {
        super();
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

}
