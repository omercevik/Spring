package org.example.lab3;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "prototype")
public class PrototypeBean
{
    public String getMessage()
    {
        return "PrototypeBean message!" + this.toString();
    }
}
