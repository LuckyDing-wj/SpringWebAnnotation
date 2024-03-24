package com.example.annotation.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.List;

public class LoginInterceptor implements HandlerInterceptor {

    private List<String> permitUser = List.of("zhangsan", "lisi", "admin");

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String user = request.getParameter("user");
        if (permitUser.contains(user)) {
            System.out.println("用户：" + user + "有权限访问");
            return true;
        }
        return false;
    }
}
