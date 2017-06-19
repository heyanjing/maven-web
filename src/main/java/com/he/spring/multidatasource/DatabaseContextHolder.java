package com.he.spring.multidatasource;

/**
 * Created by heyanjing on 2017/6/19 10:23.
 */
public class DatabaseContextHolder {
    public static final  String              DATA_SOURCE_MYSQL = "mysql";
    public static final  String              DATA_SOURCE_SQLSERVER = "sqlserver";
    private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();

    public static void setCustomerType(String customerType) {
        contextHolder.set(customerType);
    }

    public static String getCustomerType() {
        return contextHolder.get();
    }

    public static void clearCustomerType() {
        contextHolder.remove();
    }
}
