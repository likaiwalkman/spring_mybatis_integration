package org.victor.learnspring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.victor.learnspring.beans.MyFirstBean;

public class App {
    public static void main(String[] args) {
        ApplicationContext cxt = new ClassPathXmlApplicationContext("app.xml");
        //MyFirstBean bean1 = cxt.getBean("bean1", MyFirstBean.class);
        MyFirstBean bean2 = cxt.getBean("bean1", MyFirstBean.class);
        System.out.println(bean2);
        bean2.access();
//        System.out.println(bean1 == bean2);
//        System.out.println(bean1.getP());
    }
}
