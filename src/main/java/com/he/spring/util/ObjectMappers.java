package com.he.spring.util;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.common.collect.Lists;
import com.he.spring.Constants;

/**
 * 提供json与obj之间的转换
 */
public class ObjectMappers {

	// ########################################
	// ###***********创建ObjectMapper**************####
	// ########################################
	public static ObjectMapper newObjectMapper(ObjectMapper mapper, String dateFormat) {
		if (mapper == null) {
			mapper = new ObjectMapper();
			mapper.configure(SerializationFeature.WRITE_NULL_MAP_VALUES, true);
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			mapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true); // 单引号
			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);// 未引号字段
		}
		if (dateFormat == null) {
			dateFormat = Constants.DateInfo.DATETIME;
			mapper.setDateFormat(new SimpleDateFormat(dateFormat));
		}
		return mapper;
	}

	public static ObjectMapper getInstance(String dateFormat) {
		return newObjectMapper(null, dateFormat);
	}

	public static ObjectMapper getInstance() {
		return getInstance(null);
	}

	// ########################################
	// ###*************convert**************####
	// ########################################
	public static <T> T convert(ObjectMapper mapper, Object obj, String dateFormat, Class<T> clazz, TypeReference<?> type) {
		mapper = mapper == null ? getInstance(dateFormat) : mapper;
		if (type != null) {
			return mapper.convertValue(obj, type);
		} else {
			return mapper.convertValue(obj, clazz);
		}
	}

	public static <T> T convert(ObjectMapper mapper, Object obj, String dateFormat, Class<T> clazz) {
		return convert(mapper, obj, dateFormat, clazz, null);
	}

	public static <T> T convert(ObjectMapper mapper, Object obj, Class<T> clazz) {
		return convert(mapper, obj, null, clazz);
	}

	public static <T> T convert(Object obj, String dateFormat, Class<T> clazz) {
		return convert(null, obj, dateFormat, clazz, null);
	}

	public static <T> T convert(Object obj, Class<T> clazz) {
		return convert(obj, null, clazz);
	}

	public static <T> T convert(ObjectMapper mapper, Object obj, String dateFormat, TypeReference<?> type) {
		return convert(mapper, obj, dateFormat, null, type);
	}

	public static <T> T convert(ObjectMapper mapper, Object obj, TypeReference<?> type) {
		return convert(mapper, obj, null, type);
	}

	public static <T> T convert(Object obj, String dateFormat, TypeReference<?> type) {
		return convert(null, obj, dateFormat, null, type);
	}

	public static <T> T convert(Object obj, TypeReference<?> type) {
		return convert(obj, null, type);
	}

	// ########################################
	// ###**************toJson**************####
	// ########################################

	public static String toJson(ObjectMapper mapper, Object o, String dateFormat, boolean prettyFormat) {
		String json = null;
		mapper = mapper == null ? getInstance(dateFormat) : mapper;
		try {
			if (prettyFormat) {
				json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(o);
			} else {
				json = mapper.writeValueAsString(o);
			}
		} catch (Exception e) {
			throw Exceptions.newRuntimeException(e);
		}
		return json;
	}

	public static String toJson(ObjectMapper mapper, Object o) {
		return toJson(mapper, o, null, false);
	}

	public static String toJson(Object o) {
		return toJson(null, o, null, false);
	}

	public static String toJson(ObjectMapper mapper, Object o, boolean prettyFormat) {
		return toJson(mapper, o, null, prettyFormat);
	}

	public static String toJson(Object o, boolean prettyFormat) {
		return toJson(null, o, null, prettyFormat);
	}

	public static String toJson(Object o, String dateFormat, boolean prettyFormat) {
		return toJson(null, o, dateFormat, prettyFormat);
	}

	public static String toJson(Object o, String dateFormat) {
		return toJson(null, o, dateFormat, false);
	}

	// ########################################
	// ###**************toBean**************####
	// ########################################
	public static <T> T toBean(ObjectMapper mapper, String json, String dateFormat, Class<T> clazz, TypeReference<?> type) {
		mapper = mapper == null ? getInstance(dateFormat) : mapper;
		try {
			if (type != null) {
				return mapper.readValue(json, type);
			} else {
				return mapper.readValue(json, clazz);
			}
		} catch (Exception e) {
			throw Exceptions.newRuntimeException(e);
		}
	}

	public static <T> T toBean(ObjectMapper mapper, String json, Class<T> clazz) {
		return ObjectMappers.toBean(mapper, json, null, clazz, null);
	}

	public static <T> T toBean(ObjectMapper mapper, String json, TypeReference<?> type) {
		return ObjectMappers.toBean(mapper, json, null, null, type);
	}

	public static <T> T toBean(ObjectMapper mapper, String json, String dateFormat, TypeReference<?> type) {
		return ObjectMappers.toBean(mapper, json, dateFormat, null, type);
	}

	public static <T> T toBean(String json, String dateFormat, Class<T> clazz) {
		return ObjectMappers.toBean(null, json, dateFormat, clazz, null);
	}

	public static <T> T toBean(String json, Class<T> clazz) {
		return ObjectMappers.toBean(null, json, null, clazz, null);
	}

	public static <T> T toBean(String json, TypeReference<?> type) {
		return ObjectMappers.toBean(null, json, null, null, type);
	}

	public static <T> T toBean(String json, String dateFormat, TypeReference<?> type) {
		return ObjectMappers.toBean(null, json, dateFormat, null, type);
	}

	// ########################################
	// ###*************toList**************####
	// ########################################
	public static <T> List<T> toList(ObjectMapper mapper, String json, Class<T> clazz) {
		List<T> objs = Lists.newArrayList();
		List<LinkedHashMap<String, Object>> maps = toBean(mapper, json, new TypeReference<List<Object>>() {
		});
		if (maps != null) {
			for (LinkedHashMap<String, Object> map : maps) {
				objs.add(convert(mapper, map, clazz));
			}
		}
		return objs;
	}

	public static <T> List<T> toList(String json, String dateFormat, Class<T> clazz) {
		List<T> objs = Lists.newArrayList();
		List<LinkedHashMap<String, Object>> maps = toBean(json, dateFormat, new TypeReference<List<Object>>() {
		});
		if (maps != null) {
			for (LinkedHashMap<String, Object> map : maps) {
				objs.add(convert(map, clazz));
			}
		}
		return objs;
	}

	public static <T> List<T> toList(String json, Class<T> clazz) {
		List<T> objs = Lists.newArrayList();
		List<LinkedHashMap<String, Object>> maps = toBean(json, new TypeReference<List<Object>>() {
		});
		if (maps != null) {
			for (LinkedHashMap<String, Object> map : maps) {
				objs.add(convert(map, clazz));
			}
		}
		return objs;
	}

	// ########################################
	// ###*************toMap**************####
	// ########################################
	public static Map<String, Object> toMap(ObjectMapper mapper, Object obj) {
		return convert(mapper, obj, new TypeReference<HashMap<String, Object>>() {
		});
	}

	public static Map<String, Object> toMap(Object obj) {
		return convert(obj, new TypeReference<HashMap<String, Object>>() {
		});
	}
}
