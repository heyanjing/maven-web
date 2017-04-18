package com.he.spring.util;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;


public class Jsons {

	public static final String toJson(Object o) {
		return ObjectMappers.toJson(o);
	}

	public static final String toJson(Object o, boolean prettyFormat) {
		return ObjectMappers.toJson(o, prettyFormat);
	}

	public static final String toJson(Object o, String dateFormat) {
		return ObjectMappers.toJson(null, o, dateFormat, false);
	}

	public static final String toJson(Object o, String dateFormat, boolean prettyFormat) {
		return ObjectMappers.toJson(o, dateFormat, prettyFormat);
	}

	public static <T> T toBean(String jsonString, Class<T> clazz) {
		return ObjectMappers.toBean(jsonString, clazz);
	}

	public static List<Object> toList(String jsonString) {
		return ObjectMappers.toList(jsonString, Object.class);
	}

	public static <T> List<T> toList(String jsonString, Class<T> clazz) {
		return ObjectMappers.toList(jsonString, clazz);
	}

	public static Map<String, Object> toMap(String jsonString) {
		return ObjectMappers.toMap(jsonString);
	}

	public static void main(String[] args) {
		String str="{\"content\":[{\"id\":\"4028c6ee593f520201593f52f6e50000\",\"name\":\"name1\",\"age\":13,\"birthday\":1482826119000,\"names\":\"name1窝草\"},{\"id\":\"4028c6ee59915f080159916edab40010\",\"name\":\"name10\",\"age\":13,\"birthday\":1484203678000,\"names\":\"name10窝草\"}],\"totalPages\":6,\"totalElements\":11,\"last\":false,\"number\":0,\"size\":2,\"first\":true,\"sort\":null,\"numberOfElements\":2}";
		PageResponse<Person> page=Jsons.toBean(str,PageResponse.class );
		System.out.println(page);
	}
	static public class Person implements Serializable {
	    private String id;
	    private String name;
	    private int age;
	    private Date birthday;

	    public String getId() {
	        return id;
	    }

	    public void setId(String id) {
	        this.id = id;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public int getAge() {
	        return age;
	    }

	    public void setAge(int age) {
	        this.age = age;
	    }

	    public Date getBirthday() {
	        return birthday;
	    }

	    public void setBirthday(Date birthday) {
	        this.birthday = birthday;
	    }
	}
	static class PageResponse<T> implements Serializable {
	    private List<T> content;
	    private  int totalPages;
	    private  int totalElements;
	    private  boolean last;
	    private  boolean first;
	    private  int number;
	    private  int size;
	    private  String sort;
	    private  int numberOfElements;

	    public List<T> getContent() {
	        return content;
	    }

	    public void setContent(List<T> content) {
	        this.content = content;
	    }

	    public int getTotalPages() {
	        return totalPages;
	    }

	    public void setTotalPages(int totalPages) {
	        this.totalPages = totalPages;
	    }

	    public int getTotalElements() {
	        return totalElements;
	    }

	    public void setTotalElements(int totalElements) {
	        this.totalElements = totalElements;
	    }

	    public boolean isLast() {
	        return last;
	    }

	    public void setLast(boolean last) {
	        this.last = last;
	    }

	    public boolean isFirst() {
	        return first;
	    }

	    public void setFirst(boolean first) {
	        this.first = first;
	    }

	    public int getNumber() {
	        return number;
	    }

	    public void setNumber(int number) {
	        this.number = number;
	    }

	    public int getSize() {
	        return size;
	    }

	    public void setSize(int size) {
	        this.size = size;
	    }

	    public String getSort() {
	        return sort;
	    }

	    public void setSort(String sort) {
	        this.sort = sort;
	    }

	    public int getNumberOfElements() {
	        return numberOfElements;
	    }

	    public void setNumberOfElements(int numberOfElements) {
	        this.numberOfElements = numberOfElements;
	    }
	}
}
