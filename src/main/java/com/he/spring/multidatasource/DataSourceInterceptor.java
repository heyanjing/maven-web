package com.he.spring.multidatasource;

/**
 * Created by heyanjing on 2017/6/19 10:24.
 */

import org.aspectj.lang.JoinPoint;

public class DataSourceInterceptor {

    public void setdataSourceMysql(JoinPoint jp) {
        DatabaseContextHolder.setCustomerType(DatabaseContextHolder.DATA_SOURCE_MYSQL);
    }

    public void setdataSourceSqlserver(JoinPoint jp) {
        DatabaseContextHolder.setCustomerType(DatabaseContextHolder.DATA_SOURCE_SQLSERVER);
    }
}
