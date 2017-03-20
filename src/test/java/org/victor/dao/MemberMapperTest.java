package org.victor.dao;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.victor.model.MemberExample;

public class MemberMapperTest {

    @Test
    public void test(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("springContext/applicationContext.xml");
        MemberMapper       memberMapper       = applicationContext.getBean(MemberMapper.class);
        Object             o                  = memberMapper.selectByExample(new MemberExample());
        System.out.println(o);
    }

}
