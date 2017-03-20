package org.victor.listener;

import org.springframework.web.context.ContextLoaderListener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class IocListener
        extends ContextLoaderListener
        implements ServletContextListener{
//    @Override
    public void contextInitialized1(ServletContextEvent sce) {
        System.out.println("1");
    }

//    @Override
    public void contextDestroyed2(ServletContextEvent sce) {
        System.out.println(0);
    }
}
