package com.costech.listener

import com.costech.util.Const
import org.springframework.web.context.support.WebApplicationContextUtils

import javax.servlet.ServletContextEvent
import javax.servlet.ServletContextListener

/**
 * @ClassName: WebAppContextListener
 * @description: ${description}
 * @author: yangy
 * @create: 2018-09-17 16:05
 * */
class WebAppContextListener implements ServletContextListener {

    void contextDestroyed(ServletContextEvent event) {
    }

    void contextInitialized(ServletContextEvent event) {
        Const.WEB_APP_CONTEXT = WebApplicationContextUtils.getWebApplicationContext(event.getServletContext())
    }

}
