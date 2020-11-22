package com.example.lab1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppMain
{
    public static void main(String[] args)
    {
        System.out.println("Hello world!");
        ApplicationContext appContext = new ClassPathXmlApplicationContext("app-context.xml");

        ServiceBean serviceBean = appContext.getBean(ServiceBean.class);
        
        System.out.println(serviceBean.getMessage());
    }
}
