package org.example.lab3;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration
{
    @Value("${person.occupation}")
    String occupation;

    @Bean("anOtherBean")
    public PersonBean personBean()
    {
        PersonBean personBean = new PersonBean("Workshop-hero",24);
        personBean.setNickName("wh");
        personBean.setOccupation("Engineer");
        return personBean;
    }
}
