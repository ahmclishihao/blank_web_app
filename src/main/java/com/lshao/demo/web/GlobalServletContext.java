package com.lshao.demo.web;

import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * 获取全局applicationContext
 * @author lish [254174981@qq.com]
 * @date 17-12-2
 */
@Component
public class GlobalServletContext implements ServletContextInitializer {

    private ServletContext servletContext;

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        this.servletContext = servletContext;

        // 添加系统常量
        servletContext.setAttribute("base",servletContext.getContextPath());
    }

    /**
     * 获取 servletContext 的值。
     *
     * @return
     */
    public ServletContext getServletContext() {
        return servletContext;
    }
}
