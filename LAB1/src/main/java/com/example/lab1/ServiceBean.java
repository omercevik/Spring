package com.example.lab1;

public class ServiceBean
{
    private ActualBusinessComponent actualBusinessComponent;

    public String getMessage()
    {
        return actualBusinessComponent.doActualBusiness();
    }

    public void setActualBusinessComponent(ActualBusinessComponent actualBusinessComponent)
    {
        this.actualBusinessComponent = actualBusinessComponent;
    }
}
