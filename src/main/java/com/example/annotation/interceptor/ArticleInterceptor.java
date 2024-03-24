package com.example.annotation.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;

public class ArticleInterceptor implements HandlerInterceptor {

    public static final String COMMON_USER = "zhangsan";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String user = request.getParameter("user");
        String url = request.getRequestURI();
        if (COMMON_USER.equals(user) &&
                (url.startsWith("/article/add") || url.startsWith("/article/delete") || url.startsWith("/article/update"))){
            return false;
        }
        return true;
    }
}
