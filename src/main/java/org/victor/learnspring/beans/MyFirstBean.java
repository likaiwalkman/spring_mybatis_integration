package org.victor.learnspring.beans;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.util.StopWatch;

import java.lang.reflect.Method;

public class MyFirstBean implements BeanFactoryPostProcessor, BeanPostProcessor, IMySQLAccessor {

    public MyFirstBean() {
        System.out.println("constructor被调用");
    }

    private String p;

    public void setP(String p) {
        this.p = p;
    }

    public String getP() {
        return p;
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("BeanFactoryPostProcessor的postProcessBeanFactory方法被调用");
        BeanDefinition bean1 = beanFactory.getBeanDefinition("bean1");
        System.out.println(bean1);
        //bean1.get
        /*BeanDefinition bean1 = beanFactory.getBeanDefinition("bean1");
        bean1.setScope(BeanDefinition.SCOPE_SINGLETON);
        if (bean1.getPropertyValues().contains("p")) {
            bean1.getPropertyValues().add("p", "hh");
        }*/
    }

    @Override
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        System.out.println("BeanPostProcessor的postProcessBeforeInitialization方法被调用");
        return o;
    }

    @Override
    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        System.out.println("BeanPostProcessor的postProcessAfterInitialization方法被调用");
        if ("bean1".equals(s)) {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(MyFirstBean.class);
            enhancer.setCallback(new MethodInterceptor() {
                @Override
                public Object intercept(Object innerO, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                    StopWatch stopWatch = new StopWatch();
                    stopWatch.start();
                    Object invokeRes = method.invoke(o, objects);
                    stopWatch.stop();

                    if (method.getName().equals("access")) {
                        System.out.println("cost:" + stopWatch.getTotalTimeMillis());
                    }
                    return invokeRes;
                }
            });
            Object newProxyInstance = enhancer.create();
            return newProxyInstance;
        }
        return o;
    }

    @Override
    public void access() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("raw");
    }
}
