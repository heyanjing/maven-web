package com.he.spring.handler;

import com.he.spring.Constants;
import com.he.spring.util.Exceptions;
import com.he.spring.util.Jsons;
import com.he.spring.util.Logs;
import com.he.spring.util.Servlets;
import com.he.spring.util.Strings;
import com.he.spring.util.Webs;
import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

public class HandlerException extends SimpleMappingExceptionResolver {
    private static final int    ERROR_STATUSCODE           = 500;
    private static final String ERROR_MSG_500              = "服务器忙碌,请稍后再试!";
    private static final String ERROR_MSG_DEFAULT_NO_PERMS = "对不起，您没有权限访问该资源!";


    @Override
    protected void prepareResponse(Exception ex, HttpServletResponse response) {
        super.prepareResponse(ex, response);
    }

    @Override
    protected ModelAndView doResolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        ModelAndView mv = null;
        // 解析
        String url = Servlets.getRequestURL(request);
        String params = Jsons.toJson(request.getParameterMap());
        String msg_log = "\n ";
        // 返回
        Integer statusCode = ERROR_STATUSCODE;
        String msg_out = ERROR_MSG_500;
        ex = (Exception) Exceptions.getRootCause(ex);
        if (ex instanceof Exception) {
            String msg_log_url = Strings.format(Constants.ExceptionInfo.LOG_ERROR_FORMAT_URL_PARAM, url, params);
            if (ex instanceof RuntimeException) {
                // 底层甩上来的异常，添加URL和PARAM
                msg_log += msg_log_url + "\n" + ex.getMessage();
            } else {
                // 容器以及Controller的异常
                if (null != handler) { // 获取到对应的Handler时候，无法解析方法名和参数，
                    Method handlerMethod = ((HandlerMethod) handler).getMethod();
                    String method = handlerMethod.getName();
                    String clazz = handlerMethod.getDeclaringClass().getSimpleName();
                    msg_log += "\n" + msg_log_url + "\n" + Strings.format(Constants.ExceptionInfo.LOG_ERROR_FORMAT_CLASS_METHOD_EXCEPTION, clazz, method, ex.getMessage());
                } else {// 获取不到对应的Handler时候，则只记录URL和PARAM
                    msg_log += Strings.format(Constants.ExceptionInfo.LOG_ERROR_FORMAT_URL_PARAM_EXCEPTION, url, params, ex.getMessage());
                }
            }
            if (ex instanceof AuthorizationException) {// 没登陆
                msg_out = ERROR_MSG_DEFAULT_NO_PERMS;
            }
        }
        // 根据调试决定输出
        if (Constants.APP_DEBUG) {
            msg_log += "\n返回状态:" + statusCode + "\n返回消息:" + msg_out;
            msg_out = msg_log.replaceAll("\n", "<br/>");
            msg_log += "\n异常详情";
            // msg_out += Jsons.toJson(ex.getStackTrace());
        }
        if (Webs.isAjaxRequest(request)) {
            applyStatusCodeIfPossible(request, response, statusCode);// Ajax请求,返回200,防止页面报错
            try {
                Servlets.writeJsonErrorData(response, msg_out, statusCode);
            } catch (IOException ioe) {
                Logs.error(this, "返回JSON异常信息错误!", ioe);
            }
        }
        // 记录日志
        Logs.error(this, msg_log, ex);
        // super.doResolveException(request, response, handler, ex);
        // 以下：
        String viewName = determineViewName(ex, request);
        if (viewName != null) {
            statusCode = determineStatusCode(request, viewName);
            if (statusCode != null) {
                applyStatusCodeIfPossible(request, response, statusCode);
            }
            ex = Exceptions.newRuntimeException(msg_out, ex);// 包裹并输出,必须在determineViewName后面，否则将根据RuntimeException去找输出页面。
            mv = getModelAndView(viewName, ex, request);
        }
        return mv;
    }
}
