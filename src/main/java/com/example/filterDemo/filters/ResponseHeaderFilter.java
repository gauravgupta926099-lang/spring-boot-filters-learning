package com.example.filterDemo.filters;


import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.UUID;

//@Component
public class ResponseHeaderFilter implements Filter {


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    HttpServletRequest httpRequest=(HttpServletRequest)request;
    HttpServletResponse httpResponse=(HttpServletResponse)response;
    String reqID= UUID.randomUUID().toString();
    httpResponse.setHeader("requestID",reqID);
    chain.doFilter(request,response);
    }
}
