package com.he.spring.multidatasource;

/**
 * Created by heyanjing on 2017/6/19 10:22.
 */

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class DynamicDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        return DatabaseContextHolder.getCustomerType();
    }
}
