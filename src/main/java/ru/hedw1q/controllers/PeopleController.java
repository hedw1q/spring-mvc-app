package ru.hedw1q.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author hedw1q
 */
@Controller
public class PeopleController {

    @GetMapping("/")
    public String getMainPage(){
        return "main_page";
    }


}
