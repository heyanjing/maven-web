package com.he.spring.base.util;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import com.google.common.collect.Lists;
import com.he.spring.util.Strings;

public final class Querys {

    public enum Type {
        SQL, HQL, JPQL
    }

    // ----------------------------------------------------------------
    // -----------------hibernate的Query ---------------------------------
    // ----------------------------------------------------------------
    @SuppressWarnings("unchecked")
    public static Query createQuery(Session session, String sql, Object params, Type queryType) {
        Query query = null;
        if (queryType.equals(Type.SQL)) {
            query = session.createSQLQuery(sql);
        } else {
            query = session.createQuery(sql);
        }
        if (params != null) {
            if (params instanceof Map) {
                // query.setParameter("name", "name1x");
                Map<String, Object> map = (Map<String, Object>) params;
                for (Entry<String, Object> param : map.entrySet()) {
                    query.setParameter(param.getKey(), param.getValue());
                }
            } else {
                Object[] args = (Object[]) params;
                for (int i = 0; i < args.length; i++) {
                    query.setParameter(i, args[i]);
                }
            }
        }
        return query;
    }

    // ----------------------------------------------------------------
    // -----------------Spring data 相关 ---------------------------------
    // ----------------------------------------------------------------
    public static Sort createSortFilter(Map<String, String> sort) {
        Sort sorter = null;
        List<Sort> sorters = Lists.newArrayList();
        if (sort != null && !sort.isEmpty()) {
            for (Entry<String, String> entry : sort.entrySet()) {
                String name = entry.getKey();
                String value = entry.getValue();
                if (Strings.isNullOrEmpty(value)) {
                    sorters.add(new Sort(Direction.ASC, name));
                } else {
                    if (value.trim().toLowerCase().equals("asc")) {
                        sorters.add(new Sort(Direction.ASC, name));
                    } else {
                        sorters.add(new Sort(Direction.DESC, name));
                    }
                }
            }
            sorter = sorters.get(0);
            for (int i = 1; i < sorters.size(); i++) {
                sorter = sorter.and(sorters.get(i));
            }
        }
        return sorter;
    }
}