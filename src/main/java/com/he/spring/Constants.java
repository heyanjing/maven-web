package com.he.spring;

import com.google.common.base.Charsets;
import com.he.spring.util.Configs;
import com.he.spring.util.Dates;

import java.nio.charset.Charset;

/**
 * 提供基础的常量
 */
public interface Constants {
	public static String	VERSION			= Dates.newDateString(DateInfo.NONE);
	public static String	CONFIG_PROPS	= "config/config-dev.properties";
	public static boolean	APP_DEBUG		= Configs.getBoolean("app_debug", false);

	public static interface ExceptionInfo {
		public static final String	LOG_ERROR_FORMAT_CLASS						= "错误类名:%s";
		public static final String	LOG_ERROR_FORMAT_METHOD						= "错误方法:%s";
		public static final String	LOG_ERROR_FORMAT_ARG						= "方法参数:%s";
		public static final String	LOG_ERROR_FORMAT_EXCEPTION					= "异常信息:%s";
		public static final String	LOG_ERROR_FORMAT_URL						= "请求地址:%s";
		public static final String	LOG_ERROR_FORMAT_PARAM						= "请求参数:%s";

		public static final String	LOG_ERROR_FORMAT_CLASS_METHOD_EXCEPTION		= LOG_ERROR_FORMAT_CLASS + "\n" + LOG_ERROR_FORMAT_METHOD + "\n" + LOG_ERROR_FORMAT_EXCEPTION;
		public static final String	LOG_ERROR_FORMAT_CLASS_METHOD_ARG_EXCEPTION	= LOG_ERROR_FORMAT_CLASS + "\n" + LOG_ERROR_FORMAT_METHOD + "\n" + LOG_ERROR_FORMAT_ARG + "\n" + LOG_ERROR_FORMAT_EXCEPTION;

		public static final String	LOG_ERROR_FORMAT_URL_PARAM					= LOG_ERROR_FORMAT_URL + "\n" + LOG_ERROR_FORMAT_PARAM;
		public static final String	LOG_ERROR_FORMAT_URL_PARAM_EXCEPTION		= LOG_ERROR_FORMAT_URL + "\n" + LOG_ERROR_FORMAT_PARAM + "\n" + LOG_ERROR_FORMAT_EXCEPTION;

		public static final Charset	CHARSET_DEFAULT								= Charsets.UTF_8;
	}

	public static interface PageInfo {
		public static final Integer	PAGE_NUMBER	= 1;
		public static final Integer	PAGE_SIZE	= 20;
	}

	/**
	 * 日期相关的常量
	 */
	public static interface DateInfo {

		public static final String	DATE							= "yyyy-MM-dd";
		public static final String	DATETIME						= "yyyy-MM-dd HH:mm:ss";
		public static final String	T_TIME							= "yyyy-MM-dd'T'HH:mm:ss";
		public static final String	DATETIME_SSS					= "yyyy-MM-dd HH:mm:ss.SSS";
		public static final String	T_TIME_SSS						= "yyyy-MM-dd'T'HH:mm:ss.SSS";
		public static final String	ISO								= "yyyy-MM-dd'T'HH:mm:ss'Z'";		// ISO8601
		public static final String	ISO_SSS							= "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";	// ISO8601.SSS
		public static final String	NONE							= "yyyyMMddHHmmssSSS";
		public static final String	DATETIME_NONE					= "yyyyMMddHHmmss";
		public static final String	FORMAT_DATE_TOSTRING_DEFAULT	= "EEE MMM dd HH:mm:ss zzz yyyy";	// Date对象自带toString的格式
	}

	/**
	 * 加密相关的常量
	 */
	public static interface CryptosInfo {
		public static final String	SHA1	= "SHA-1";
		public static final String	MD5		= "MD5";
	}

	public static interface CharInfo {
		public static final char[]	BASE62	= "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".toCharArray();
		public String				UTF_8	= "UTF-8";

	}

	public static interface MediaTypesInfo {

		public static final String	TEXT_PLAIN_VALUE					= "text/plain";
		public static final String	TEXT_PLAIN_UTF_8_VALUE				= "text/plain;charset=UTF-8";

		public static final String	TEXT_HTML_VALUE						= "text/html";
		public static final String	TEXT_HTML_UTF_8_VALUE				= "text/html;charset=UTF-8";

		public static final String	APPLICATION_JSON_VALUE				= "application/json";
		public static final String	APPLICATION_JSON_UTF_8_VALUE		= "application/json;charset=UTF-8";

		public static final String	TEXT_XML_VALUE						= "text/xml";
		public static final String	TEXT_XML_UTF_8_VALUE				= "text/xml;charset=UTF-8";

		public static final String	APPLICATION_XML_VALUE				= "application/xml";
		public static final String	APPLICATION_XML_UTF_8_VALUE			= "application/xml; charset=UTF-8";

		public static final String	APPLICATION_JAVASCRIPT_VALUE		= "application/javascript";
		public static final String	APPLICATION_JAVASCRIPT_UTF_8_VALUE	= "application/javascript; charset=UTF-8";

		public static final String	APPLICATION_XHTML_XML_VALUE			= "application/xhtml+xml";
		public static final String	APPLICATION_XHTML_XML_UTF_8_VALUE	= "application/xhtml+xml; charset=UTF-8";

		public static final String	APPLICATION_OCTET_STREAM_VALUE		= "application/octet-stream";

	}

	public static interface HttpStatusInfo {

		// --- 1xx Informational ---

		/** {@code 100 Continue} (HTTP/1.1 - RFC 2616) */
		public static final int	SC_CONTINUE							= 100;
		/** {@code 101 Switching Protocols} (HTTP/1.1 - RFC 2616) */
		public static final int	SC_SWITCHING_PROTOCOLS				= 101;
		/** {@code 102 Processing} (WebDAV - RFC 2518) */
		public static final int	SC_PROCESSING						= 102;

		// --- 2xx Success ---

		/** {@code 200 OK} (HTTP/1.0 - RFC 1945) */
		public static final int	SC_OK								= 200;
		/** {@code 201 Created} (HTTP/1.0 - RFC 1945) */
		public static final int	SC_CREATED							= 201;
		/** {@code 202 Accepted} (HTTP/1.0 - RFC 1945) */
		public static final int	SC_ACCEPTED							= 202;
		/** {@code 203 Non Authoritative Information} (HTTP/1.1 - RFC 2616) */
		public static final int	SC_NON_AUTHORITATIVE_INFORMATION	= 203;
		/** {@code 204 No Content} (HTTP/1.0 - RFC 1945) */
		public static final int	SC_NO_CONTENT						= 204;
		/** {@code 205 Reset Content} (HTTP/1.1 - RFC 2616) */
		public static final int	SC_RESET_CONTENT					= 205;
		/** {@code 206 Partial Content} (HTTP/1.1 - RFC 2616) */
		public static final int	SC_PARTIAL_CONTENT					= 206;
		/**
		 * {@code 207 Multi-Status} (WebDAV - RFC 2518) or {@code 207 Partial Update OK} (HTTP/1.1 - draft-ietf-http-v11-spec-rev-01?)
		 */
		public static final int	SC_MULTI_STATUS						= 207;

		// --- 3xx Redirection ---

		/** {@code 300 Mutliple Choices} (HTTP/1.1 - RFC 2616) */
		public static final int	SC_MULTIPLE_CHOICES					= 300;
		/** {@code 301 Moved Permanently} (HTTP/1.0 - RFC 1945) */
		public static final int	SC_MOVED_PERMANENTLY				= 301;
		/** {@code 302 Moved Temporarily} (Sometimes {@code Found}) (HTTP/1.0 - RFC 1945) */
		public static final int	SC_MOVED_TEMPORARILY				= 302;
		/** {@code 303 See Other} (HTTP/1.1 - RFC 2616) */
		public static final int	SC_SEE_OTHER						= 303;
		/** {@code 304 Not Modified} (HTTP/1.0 - RFC 1945) */
		public static final int	SC_NOT_MODIFIED						= 304;
		/** {@code 305 Use Proxy} (HTTP/1.1 - RFC 2616) */
		public static final int	SC_USE_PROXY						= 305;
		/** {@code 307 Temporary Redirect} (HTTP/1.1 - RFC 2616) */
		public static final int	SC_TEMPORARY_REDIRECT				= 307;

		// --- 4xx Client Error ---

		/** {@code 400 Bad Request} (HTTP/1.1 - RFC 2616) */
		public static final int	SC_BAD_REQUEST						= 400;
		/** {@code 401 Unauthorized} (HTTP/1.0 - RFC 1945) */
		public static final int	SC_UNAUTHORIZED						= 401;
		/** {@code 402 Payment Required} (HTTP/1.1 - RFC 2616) */
		public static final int	SC_PAYMENT_REQUIRED					= 402;
		/** {@code 403 Forbidden} (HTTP/1.0 - RFC 1945) */
		public static final int	SC_FORBIDDEN						= 403;
		/** {@code 404 Not Found} (HTTP/1.0 - RFC 1945) */
		public static final int	SC_NOT_FOUND						= 404;
		/** {@code 405 Method Not Allowed} (HTTP/1.1 - RFC 2616) */
		public static final int	SC_METHOD_NOT_ALLOWED				= 405;
		/** {@code 406 Not Acceptable} (HTTP/1.1 - RFC 2616) */
		public static final int	SC_NOT_ACCEPTABLE					= 406;
		/** {@code 407 Proxy Authentication Required} (HTTP/1.1 - RFC 2616) */
		public static final int	SC_PROXY_AUTHENTICATION_REQUIRED	= 407;
		/** {@code 408 Request Timeout} (HTTP/1.1 - RFC 2616) */
		public static final int	SC_REQUEST_TIMEOUT					= 408;
		/** {@code 409 Conflict} (HTTP/1.1 - RFC 2616) */
		public static final int	SC_CONFLICT							= 409;
		/** {@code 410 Gone} (HTTP/1.1 - RFC 2616) */
		public static final int	SC_GONE								= 410;
		/** {@code 411 Length Required} (HTTP/1.1 - RFC 2616) */
		public static final int	SC_LENGTH_REQUIRED					= 411;
		/** {@code 412 Precondition Failed} (HTTP/1.1 - RFC 2616) */
		public static final int	SC_PRECONDITION_FAILED				= 412;
		/** {@code 413 Request Entity Too Large} (HTTP/1.1 - RFC 2616) */
		public static final int	SC_REQUEST_TOO_LONG					= 413;
		/** {@code 414 Request-URI Too Long} (HTTP/1.1 - RFC 2616) */
		public static final int	SC_REQUEST_URI_TOO_LONG				= 414;
		/** {@code 415 Unsupported Media Type} (HTTP/1.1 - RFC 2616) */
		public static final int	SC_UNSUPPORTED_MEDIA_TYPE			= 415;
		/** {@code 416 Requested Range Not Satisfiable} (HTTP/1.1 - RFC 2616) */
		public static final int	SC_REQUESTED_RANGE_NOT_SATISFIABLE	= 416;
		/** {@code 417 Expectation Failed} (HTTP/1.1 - RFC 2616) */
		public static final int	SC_EXPECTATION_FAILED				= 417;

		/**
		 * Static constant for a 418 error. {@code 418 Unprocessable Entity} (WebDAV drafts?) or {@code 418 Reauthentication Required} (HTTP/1.1 drafts?)
		 */
		// not used
		// public static final int SC_UNPROCESSABLE_ENTITY = 418;

		/**
		 * Static constant for a 419 error. {@code 419 Insufficient Space on Resource} (WebDAV - draft-ietf-webdav-protocol-05?) or {@code 419 Proxy Reauthentication Required} (HTTP/1.1 drafts?)
		 */
		public static final int	SC_INSUFFICIENT_SPACE_ON_RESOURCE	= 419;
		/**
		 * Static constant for a 420 error. {@code 420 Method Failure} (WebDAV - draft-ietf-webdav-protocol-05?)
		 */
		public static final int	SC_METHOD_FAILURE					= 420;
		/** {@code 422 Unprocessable Entity} (WebDAV - RFC 2518) */
		public static final int	SC_UNPROCESSABLE_ENTITY				= 422;
		/** {@code 423 Locked} (WebDAV - RFC 2518) */
		public static final int	SC_LOCKED							= 423;
		/** {@code 424 Failed Dependency} (WebDAV - RFC 2518) */
		public static final int	SC_FAILED_DEPENDENCY				= 424;

		// --- 5xx Server Error ---

		/** {@code 500 Server Error} (HTTP/1.0 - RFC 1945) */
		public static final int	SC_INTERNAL_SERVER_ERROR			= 500;
		/** {@code 501 Not Implemented} (HTTP/1.0 - RFC 1945) */
		public static final int	SC_NOT_IMPLEMENTED					= 501;
		/** {@code 502 Bad Gateway} (HTTP/1.0 - RFC 1945) */
		public static final int	SC_BAD_GATEWAY						= 502;
		/** {@code 503 Service Unavailable} (HTTP/1.0 - RFC 1945) */
		public static final int	SC_SERVICE_UNAVAILABLE				= 503;
		/** {@code 504 Gateway Timeout} (HTTP/1.1 - RFC 2616) */
		public static final int	SC_GATEWAY_TIMEOUT					= 504;
		/** {@code 505 HTTP Version Not Supported} (HTTP/1.1 - RFC 2616) */
		public static final int	SC_HTTP_VERSION_NOT_SUPPORTED		= 505;

		/** {@code 507 Insufficient Storage} (WebDAV - RFC 2518) */
		public static final int	SC_INSUFFICIENT_STORAGE				= 507;

	}

	public static interface ImageInfo {
		public static String[]	IMAGES	= { "bmp", "jpg", "jpeg", "gif", "png", "tiff" };
		public static String	JPG		= "jpg";
	}
}
