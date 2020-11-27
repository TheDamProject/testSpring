package com.toni.spring.rest.CONTROLLER;


import com.toni.spring.rest.MODEL.Person;
import com.toni.spring.rest.REPOSITORY.PersonInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DemoController {

    @Autowired
    private PersonInterface repoPerson ;

    @GetMapping("/inicio")
    public String inicio(@RequestParam(name="name" , required = false, defaultValue = "Mundo") String name, Model model){

        Person person1 = new Person();
        person1.setId(1);
        person1.setName("Antonio");

        repoPerson.save(person1);

        model.addAttribute("name" , name);
        return "index";

    }
}
