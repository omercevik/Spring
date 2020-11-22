package com.example.lab7;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.LinkedHashMap;
import java.util.Map;

@Controller
public class WebMvcController
{
    @Autowired
    CustomerRepository customerRepository;

    @RequestMapping("/hello")
    public ModelAndView sayHello()
    {
        Map<String, Object> model = new LinkedHashMap<String, Object>();

        model.put("name","Ömer");
        model.put("customers",customerRepository.findAll());

        return new ModelAndView("hello",model);

    }
}
