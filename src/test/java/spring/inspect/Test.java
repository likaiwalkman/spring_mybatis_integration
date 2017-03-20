package spring.inspect;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans/beans.xml");
        System.out.println(ctx);
        Object o = ctx.getBean("student1");
        System.out.println(o);

    }
}
