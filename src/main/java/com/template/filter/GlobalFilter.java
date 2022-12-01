package com.template.filter;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import javax.servlet.*;
import javax.servlet.Filter;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.Duration;
import java.time.LocalTime;
import java.util.Base64;
import java.util.Date;
import java.util.Enumeration;

/**
* @Description: 全局过滤
* @Author: xjm
* @Date: 2021/9/12
*/
@WebFilter(urlPatterns = "/*", filterName = "GlobalFilter")
@Component
@Slf4j
@Order
public class GlobalFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;

        //请求时的系统时间
        LocalTime startTime = LocalTime.now();
        filterChain.doFilter(servletRequest, servletResponse);


    }

    @Override
    public void destroy() {

    }




}
