package com.lcvc.ebuy_maven_ssm.web.filter;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginForAdminInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object handler) throws  Exception{
        boolean judge=false;
        HttpSession session=request.getSession();
        if (session.getAttribute("admin")!=null){
            judge=true;
        }else{
            String path=request.getContextPath();
            String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
            response.sendRedirect(basePath+"backstage/toLogin");
        }
        return judge;
    }
}
