package com.he.spring.shiro.filter;

import com.he.spring.util.Logs;
import com.he.spring.util.Servlets;
import com.he.spring.util.Webs;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.slf4j.Logger;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by heyanjing on 2017/6/19 15:07.
 */
public class AjaxFormAuthenticationFilter extends FormAuthenticationFilter {

    private static final Logger LOGGER = Logs.getLogger(AjaxFormAuthenticationFilter.class);

    /**
     * 访问被拒绝后的回调
     */
    @Override

    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        if (Webs.isAjaxRequest(request)) {
            if (!isLoginRequest(request, response) || !isLoginSubmission(request, response)) {// 非登陆请求，非登陆操作。
                // 返回访问受限状态码，ajax回调error
                // if(data.status===403){
                //window.location.href=CTX;
                Servlets.writeJsonData(response, 403);
                //WebUtils.issueRedirect(request, response, accessDeniedUrl);
            }
            return false;
        } else {
            return super.onAccessDenied(servletRequest, servletResponse);
        }
    }

    //region Description
  /*
  protected boolean onAccessDenied_x(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        if (Webs.isAjaxRequest(request)) {
            if (!isLoginRequest(request, response) || !isLoginSubmission(request, response)) {// 非登陆请求，非登陆操作。
                String msg = "未登陆或登陆超时，请重新登陆!";
                Servlets.setStatus403(response);
                Servlets.writeJsonErrorData(response, null, 403);
            }
            return false;
        } else {
            return super.onAccessDenied(servletRequest, servletResponse);
        }
    }

    protected boolean onAccessDenied_m(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        if (isLoginRequest(request, response)) {// 是否登陆请求
            if (isLoginSubmission(request, response)) {// 是否登录操作
                if (Webs.isAjaxRequest(httpServletRequest)) {
                    String url = Servlets.getRequestURL(httpServletRequest);
                    String msg = "没权限";
                    Servlets.writeJsonErrorData(httpServletResponse, msg, 403);
                    return false;
                }
            }
            return super.onAccessDenied(request, response);
        } else {
            if (Webs.isAjaxRequest(httpServletRequest)) {
                String url = Servlets.getRequestURL(httpServletRequest);
                String msg = "没权限";
                Servlets.writeJsonErrorData(httpServletResponse, msg, 403);
                return false;
            }
            return super.onAccessDenied(request, response);
        }
    }

    protected boolean onAccessDenied_s(ServletRequest request, ServletResponse response) throws Exception {
        if (isLoginRequest(request, response)) {
            if (isLoginSubmission(request, response)) {
                if (LOGGER.isTraceEnabled()) {
                    LOGGER.trace("Login submission detected.  Attempting to execute login.");
                }
                if ("XMLHttpRequest".equalsIgnoreCase(((HttpServletRequest) request).getHeader("X-Requested-With"))) {// 不是ajax请求
                    String vcode = request.getParameter("vcode");
                    HttpServletRequest httpservletrequest = (HttpServletRequest) request;
                    String vvcode = (String) httpservletrequest.getSession().getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
                    if (vvcode == null || "".equals(vvcode) || !vvcode.equals(vcode)) {
                        response.setCharacterEncoding("UTF-8");
                        PrintWriter out = response.getWriter();
                        out.println("{success:false,message:'验证码错误'}");
                        out.flush();
                        out.close();
                        return false;
                    }
                }
                return executeLogin(request, response);
            } else {
                if (LOGGER.isTraceEnabled()) {
                    LOGGER.trace("Login page view.");
                }
                // allow them to see the login page ;)
                return true;
            }
        } else {
            if (LOGGER.isTraceEnabled()) {
                LOGGER.trace("Attempting to access a path which requires authentication.  Forwarding to the " + "Authentication url [" + getLoginUrl() + "]");
            }
            if (!"XMLHttpRequest".equalsIgnoreCase(((HttpServletRequest) request).getHeader("X-Requested-With"))) {// 不是ajax请求
                saveRequestAndRedirectToLogin(request, response);
            } else {
                response.setCharacterEncoding("UTF-8");
                PrintWriter out = response.getWriter();
                out.println("{success:true,message:'login'}");
                out.flush();
                out.close();
                return true;
            }
            return false;
        }
    }

    */
    //endregion
}
