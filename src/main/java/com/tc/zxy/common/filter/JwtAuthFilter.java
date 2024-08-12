package com.tc.zxy.common.filter;

import com.tc.zxy.common.util.JwtUtil;
import jakarta.annotation.Resource;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.catalina.util.StringUtil;
import org.apache.logging.log4j.util.Strings;
import org.apache.tomcat.util.modeler.Util;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;


public class JwtAuthFilter implements Filter {

    @Resource
    private JwtUtil jUtil;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String path = request.getRequestURI().substring(request.getContextPath().length());
        if (path.startsWith("/login")) {
            filterChain.doFilter(request, response);
            return;
        }

        String jwt = request.getHeader("JWT");
        if (Strings.isEmpty(jwt)) {
            String userName = jUtil.extractUsername(jwt);
        }



        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
