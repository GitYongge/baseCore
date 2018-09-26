package com.costech.interceptor

import com.costech.entity.system.User
import com.costech.util.Const
import com.costech.util.Jurisdiction
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter

import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * @ClassName: LoginHandlerInterceptor
 * @description: 登录过滤，权限验证
 * @author: yangy
 * @create: 2018-09-17 15:42
 * */
class LoginHandlerInterceptor extends HandlerInterceptorAdapter {

    boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String path = request.getServletPath()
        if(path.matches(Const.NO_INTERCEPTOR_PATH)){
            return true
        }else{
            User user = (User)Jurisdiction.getSession().getAttribute(Const.SESSION_USER)
            if(user!=null){
                path = path.substring(1, path.length())
                boolean b = Jurisdiction.hasJurisdiction(path) //访问权限校验
                if(!b){
                    response.sendRedirect(request.getContextPath() + Const.LOGIN)
                }
                return b
            }else{
                //登陆过滤
                response.sendRedirect(request.getContextPath() + Const.LOGIN)
                return false
            }
        }
    }
}
