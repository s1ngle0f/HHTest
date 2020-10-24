package ru.zubkov.hhtest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.zubkov.hhtest.otherscripts.DataBases;
import ru.zubkov.hhtest.otherscripts.Person;
import ru.zubkov.hhtest.otherscripts.Person;

@Controller
@RequestMapping("/main")
public class MainController {

    private final DataBases dao;

    @Autowired
    public MainController(DataBases dao) {
        this.dao = dao;
    }

    @GetMapping()
    public String mainpage(Model model){
        model.addAttribute( "people", dao.getDAO() );
        return "mainpage";
    }

    @GetMapping("/{id}")
    public String idpage(@PathVariable("id") int id, Model model){
        model.addAttribute( "dao", dao );
        model.addAttribute( "id", id );
        return "idpage";
    }

    @GetMapping("/new")
    public String newPerson(Model model){
        model.addAttribute("person", new Person() );
        return "new";
    }

    @GetMapping("/{id}/edit")
    public String editNote(@PathVariable("id") int id, Model model){
        model.addAttribute( "person", dao.getPersonById(id) );
        return "editNote";
    }

    @PostMapping()
    public String createnewPerson( @ModelAttribute("person") Person person ){
        dao.create( person );
        return "redirect:/main";
    }

}
