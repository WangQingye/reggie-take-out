package com.wqy.reggie.filter;

import com.alibaba.fastjson.JSON;
import com.wqy.reggie.common.BaseContext;
import com.wqy.reggie.common.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.AntPathMatcher;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 检查用户是否登录
 */

@WebFilter(filterName = "loginCheckFilter", urlPatterns = "/*")
@Slf4j
public class LoginCheckFilter implements Filter {
    public static final AntPathMatcher PATH_MATCHER = new AntPathMatcher();
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        log.info("拦截到请求：{}", request.getRequestURI());
        String requestURI = request.getRequestURI();

        String[] urls = {"/employee/login", "/employee/logout", "/backend/**", "/front/**", "/common/**"};

        if (check(urls, requestURI)) {
            log.info("请求：{}不需要处理", request.getRequestURI());
            filterChain.doFilter(request,response);
            return;
        }

        if (request.getSession().getAttribute("employee") != null) {
            Long empId = (Long) request.getSession().getAttribute("employee");
            log.info("用户已登录,id：{}", empId);
            BaseContext.setCurrentId(empId);
            filterChain.doFilter(request,response);
            return;
        }
        log.info("用户未登录");
        response.getWriter().write(JSON.toJSONString(R.error("NOTLOGIN")));
        return;
    }

    public boolean check(String[] urls, String requestURI) {
        for (String url : urls) {
            boolean match = PATH_MATCHER.match(url, requestURI);
            if (match) return true;
        }
        return false;
    }
}
