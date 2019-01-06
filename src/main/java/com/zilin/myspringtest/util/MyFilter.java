package com.zilin.myspringtest.util;

import lombok.extern.log4j.Log4j2;
import org.apache.commons.io.IOUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Log4j2
public class MyFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        BodyRequestWrapper requestWrapper = new BodyRequestWrapper(request);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Request IP: " + requestWrapper.getRemoteAddr());
        stringBuilder.append(" Request url: " + requestWrapper.getRequestURI());
        stringBuilder.append(" Request method: " + requestWrapper.getMethod());
        String a = IOUtils.toString(requestWrapper.getInputStream());
        stringBuilder.append(" Request Body: " + a);
        log.info(stringBuilder);
        BodyCachingHttpServletResponseWrapper responseWrapper = new BodyCachingHttpServletResponseWrapper(response);
        filterChain.doFilter(requestWrapper,responseWrapper);
        byte[] responseBody = responseWrapper.getBody();
        log.info("Response Status: " + responseWrapper.getStatus() + " Response Body: " + new String(responseBody));
    }
}
