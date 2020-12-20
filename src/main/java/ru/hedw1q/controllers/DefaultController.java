package ru.hedw1q.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author hedw1q
 */
@Controller
@RequestMapping("/")
public class DefaultController {
    @GetMapping()
    public String reDirect(){
        return "redirect:/people";
    }
}
