package org.example.lab3;

import org.springframework.stereotype.Component;

@Component
public class SingletonBean
{
    public String getMessage()
    {
        return "SingletonBean message!" + this.toString();
    }
}
