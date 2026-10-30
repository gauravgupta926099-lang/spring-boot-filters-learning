package com.example.filterDemo.filters;


import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.util.ContentCachingResponseWrapper;

import java.io.IOException;

// @Component
public class ResponseBodyFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse httpResponse=(HttpServletResponse)response;
        HttpServletRequest httpRequest =(HttpServletRequest) request;
        ContentCachingResponseWrapper wrappedResponse=new ContentCachingResponseWrapper(httpResponse);
        chain.doFilter(httpRequest,wrappedResponse);
        byte[]originalBodyBytes=wrappedResponse.getContentAsByteArray();
        String originalBody=new String(originalBodyBytes);
        String modifiedBody=
                """
                       {"originalBody":%s,
                       "appName":"student app"
                       }
                        """.formatted(originalBody);
        wrappedResponse.getWriter().write(modifiedBody);
        wrappedResponse.copyBodyToResponse();
    }
}
