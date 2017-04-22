package com.he.spring.entity;

import com.he.spring.base.entity.BaseEntityWithStringId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "user")
@DynamicUpdate(true)
@DynamicInsert(true)
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntityWithStringId {
    @NotEmpty(message = "名字不为空")
    private String  name;
    private String  md5Password;
    private String  sha1Password;
    private String  salt;
    private Integer state;


}