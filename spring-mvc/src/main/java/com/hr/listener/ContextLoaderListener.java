package com.hr.listener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextLoaderListener implements ServletContextListener {


    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext context = servletContextEvent.getServletContext();
        //读取xml配置文件
        String contextConfigLocation = context.getInitParameter("contextConfigLocation");
        ApplicationContext app = new ClassPathXmlApplicationContext(contextConfigLocation);
        //得到只初始化一次的servletContext域, 并将spring容器存储到域中

        context.setAttribute("app", app);
        System.out.println("Spring容器创建完毕......");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
