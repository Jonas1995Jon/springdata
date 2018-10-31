package com.jonas;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Desc：
 * Author Jonas
 * 2018/10/30 17:18
 */
public class SpringDataTest {

    private ApplicationContext ctx = null;

    @Before
    public void serup(){
        ctx = new ClassPathXmlApplicationContext("beans-new.xml");
        System.out.println("setup");
    }

    @After
    public void tearDown(){
        ctx = null;
        System.out.println("tearDown");
    }

    @Test
    public void entityManagerFactory(){
        //测试自动建表
    }

}
