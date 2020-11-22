package org.example.lab3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.util.Assert;

@SpringBootApplication
public class AppMain
{
    private static ApplicationContext applicationContext;

    public static void main(String[] args)
    {
        applicationContext = SpringApplication.run(AppMain.class);

        String[] beanNames = applicationContext.getBeanDefinitionNames();
        for (String beanName : beanNames)
            System.out.println(beanName);

        assertSingleton();

        assertPrototype();

        assertPersonBean();

        assertDependencyInjection();
    }

    public static void assertSingleton()
    {
        SingletonBean singletonBean1 = applicationContext.getBean(SingletonBean.class);
        SingletonBean singletonBean2 = applicationContext.getBean(SingletonBean.class);
        SingletonBean singletonBean3 = applicationContext.getBean(SingletonBean.class);

        Assert.isTrue(singletonBean1 == singletonBean2,"Singleton Bean does not work!");
        Assert.isTrue(singletonBean1 == singletonBean3,"Singleton Bean does not work!");
    }

    public static void assertPrototype()
    {
        PrototypeBean prototypeBean1 = applicationContext.getBean(PrototypeBean.class);
        PrototypeBean prototypeBean2 = applicationContext.getBean(PrototypeBean.class);
        PrototypeBean prototypeBean3 = applicationContext.getBean(PrototypeBean.class);

        Assert.isTrue(prototypeBean1 != prototypeBean2,"Prototype Bean does not work!");
        Assert.isTrue(prototypeBean1 != prototypeBean3,"Prototype Bean does not work!");
    }

    public static void assertPersonBean()
    {
        PersonBean personBean = applicationContext.getBean("anOtherBean",PersonBean.class);
        System.out.println(personBean.getName() + " : " + personBean.getAge());

        Assert.isTrue(personBean.getAge() == 24, "Age property does not work!");
        Assert.isTrue(personBean.getName().equals("Workshop-hero"), "Name property does not work!");
        Assert.isTrue(personBean.getNickName().equals("wh"), "Nickname property does not work!");
        Assert.isTrue(personBean.getOccupation().equals("Engineer"), "Occupation property does not work!");

    }

    public static void assertDependencyInjection()
    {
        ServiceBean serviceBean = applicationContext.getBean(ServiceBean.class);
        System.out.println(serviceBean.getMessage());

        Assert.isTrue(serviceBean.getSingleton() != null,"Singleton Bean is not in service!");
        Assert.isTrue(serviceBean.getPrototype() != null,"Prototype Bean is not in service!");
    }
}
