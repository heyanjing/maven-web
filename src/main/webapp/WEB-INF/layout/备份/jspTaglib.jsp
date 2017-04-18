<%@page language="java" pageEncoding="UTF-8" %>

<%@page import="com.he.spring.Constants" %>

<%@taglib prefix="sitemesh" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<!-- 
<%@taglib prefix="sitemesh" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="tags" tagdir="/WEB-INF/tags" %>
 -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

 <c:set var="CTX" value="${pageContext.request.contextPath}" />
 <c:set var="STATIC" value="${CTX}/static" />
 <c:set var="IMG" value="${STATIC}/img" />
 <c:set var="JS" value="${STATIC}/js" />
 <c:set var="CSS" value="${STATIC}/css" />
 <c:set var="FRAMEWORK" value="${STATIC}/framework" />
 <c:set var="JQUERY" value="${FRAMEWORK}/jquery" />
 <c:set var="PDF" value="${STATIC}/pdf" />
 <c:set var="V" value="<%=Constants.VERSION%>" />
 