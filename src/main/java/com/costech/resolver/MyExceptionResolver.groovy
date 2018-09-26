package com.costech.resolver

import org.springframework.web.servlet.ModelAndView

import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * @ClassName: MyExceptionResolver
 * @description: 异常解析
 * @author: yangy
 * @create: 2018-09-17 17:08
 * */
class MyExceptionResolver {

    ModelAndView resolveException(HttpServletRequest request,HttpServletResponse response, Object handler, Exception ex) {
        System.out.println("==============异常开始=============")
        ex.printStackTrace();
        System.out.println("==============异常结束=============")
        ModelAndView mv = new ModelAndView("error")
        mv.addObject("exception", ex.toString().replaceAll("\n", "<br/>"))
        return mv
    }
}
