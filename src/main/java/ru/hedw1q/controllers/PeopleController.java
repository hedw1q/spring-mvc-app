package ru.hedw1q.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.hedw1q.dao.PersonDBService;
import ru.hedw1q.models.Person;
import javax.validation.Valid;


/**
 * @author hedw1q
 */
@Controller
@RequestMapping("/people")
public class PeopleController {
    @Autowired
    private final PersonDBService personDBService;

    PeopleController(PersonDBService personDBService) {
        this.personDBService = personDBService;
    }

    @GetMapping()
    public String showAllPeople(Model model) {
        model.addAttribute("people", personDBService.getPeople());
        return "people/all";
    }

    @GetMapping("{id}")
    public String showOnePerson(@PathVariable int id, Model model) {
        model.addAttribute("person", personDBService.show(id));
        return "people/person";
    }

    @GetMapping("/new")
    public String showNewPersonForm(@ModelAttribute("person") Person person){
        return "people/new";
    }

    @PostMapping("/create")
    public String createNewPerson(@ModelAttribute("person") @Valid Person person,
                                  BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return "people/new";
        personDBService.create(person);
        return "people/successCreate";
    }
@GetMapping("/edit/{id}")
    public String editPersonPage(@PathVariable int id, Model model){
        model.addAttribute("person", personDBService.show(id));
        return "people/edit";
}
@PostMapping("/edit/{id}")
    public String updatePerson(@ModelAttribute("person") @Valid Person person, BindingResult bindingResult,
                               @PathVariable int id){
        if(bindingResult.hasErrors())
            return "people/edit";
       personDBService.update(id, person);
       return "redirect:/people";
}
@GetMapping("/delete/{id}")
    public String deletePerson(@PathVariable int id){
        personDBService.delete(id);
        return "people/successDelete";
}
}
