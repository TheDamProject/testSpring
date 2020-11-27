package com.toni.spring.rest.CONTROLLER;


import com.toni.spring.rest.MODEL.Person;
import com.toni.spring.rest.REPOSITORY.PersonInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DemoController {

    @Autowired
    private PersonInterface repoPerson ;

    @GetMapping("/inicio")
    public String inicio(@RequestParam(name="name" , required = false, defaultValue = "Mundo") String name, Model model){



        model.addAttribute("name" , name);
        return "index";

    }
    @GetMapping("/inserta")
    public String inicio(@RequestParam(name="name" , required = false, defaultValue = "NONAME") String name,
                         @RequestParam(name="id" , required = false, defaultValue = "999") Long id,Model model){

        Person person1 = new Person();
        person1.setId(id);
        person1.setName(name);
        repoPerson.save(person1);
        repoPerson.save(person1);
        return "index";

    }

    @GetMapping("/lista")
    public String personas(Model model){

        model.addAttribute("personas", repoPerson.findAll() );
        model.addAttribute("name" , repoPerson.getOne((long) 1).getName());
        return "index";
    }




}
