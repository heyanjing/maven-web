package com.he.spring.entity;

import com.he.spring.base.entity.BaseEntityWithStringId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "subject")
@DynamicUpdate(true)
@DynamicInsert(true)
@NoArgsConstructor
public class Subject extends BaseEntityWithStringId {
    private String  id;
    private String  orgId;
    private String  orgCode;
    private String  projectId;
    private String  subjectId;
    private String  payType;
    private String  totalPrice;
    private String  isDeductLiveLearing;
    private String  years;
    private String  isExam;
    private String  isSendSms;
    private String  isMobileValidate;
    private String  isCheck;
    private String  isSelfReg;
    private String  isSchoolReg;
    private String  periods;
    private String  payTypeValue;
    private String  isExamValue;
    private String  orgName;
    private String  orgType;
    private String  idCards;
    private String  projectName;
    private String  subjectName;
    private String  times;



}
