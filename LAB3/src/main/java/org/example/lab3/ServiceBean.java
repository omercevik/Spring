package org.example.lab3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceBean
{
    @Autowired
    SingletonBean singletonBean;

    @Autowired
    PrototypeBean prototypeBean;

    public String getMessage()
    {
        return "ServiceBean message!";
    }

    public SingletonBean getSingleton() {
        return singletonBean;
    }

    public void setSingleton(SingletonBean singletonBean) {
        this.singletonBean = singletonBean;
    }

    public PrototypeBean getPrototype() {
        return prototypeBean;
    }

    public void setPrototype(PrototypeBean prototypeBean) {
        this.prototypeBean = prototypeBean;
    }
}
