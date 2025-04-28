package com.example.SpringWebMVC.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class PageController {

    // GET | POST

    @GetMapping("/home")
    public @ResponseBody String getHomePage() {
        return "Prima pagina MVC Spring";
    }

    // Endpoint con parametri di tipo Query String
    @GetMapping("/home/params")
    public @ResponseBody String getHomePageWithQueryStringParams(@RequestParam String name, @RequestParam String lastname) {
        //http://localhost:8080/home/params?name=Francesco&lastname=Rossi
        return "Prima pagina MVC Spring con paramentri " + name + " - " + lastname;
    }

    // Endpoint con parametri di tipo Path variable
    @GetMapping("/home/params/{name}/{lastname}")
    public @ResponseBody String getHomePageWithPathParams(@PathVariable String name, @PathVariable String lastname) {
        //http://localhost:8080/home/params/Mario/Rossi
        return "Prima pagina MVC Spring con paramentri " + name + " - " + lastname;
    }

    // Endpoint collegato ad una pagina HTML creata con thymeleaf
    @GetMapping("/page1")
    public String getPageThymeleaf() {
        return "pageThymeleaf";
    }

    // Endpoint con parametri collegato ad una pagina HTML creata con thymeleaf
    @GetMapping("/page1/{name}/{lastname}")
    public String getPageThymeleaf(Map<String, Object> model, @PathVariable String name, @PathVariable String lastname) {
        model.put("firstname", name);
        model.put("lastname", lastname);
        model.put("valori", "Valori passati dal client");
        model.put("method", "Map<String, Object> model");
        return "pageThymeleaf";
    }

    @GetMapping("/page2/{name}/{lastname}")
    public String getPageThymeleaf(Model model, @PathVariable String name, @PathVariable String lastname) {
        model.addAttribute("firstname", name);
        model.addAttribute("lastname", lastname);
        model.addAttribute("valori", "Valori passati dal client");
        model.addAttribute("method", "Model model");
        return "pageThymeleaf";
    }

    @GetMapping("/page3/{name}/{lastname}")
    public String getPageThymeleaf(ModelMap model, @PathVariable String name, @PathVariable String lastname) {
        model.addAttribute("firstname", name);
        model.addAttribute("lastname", lastname);
        model.addAttribute("valori", "Valori passati dal client");
        model.addAttribute("method", "ModelMap model");
        return "pageThymeleaf";
    }

    @GetMapping("/page4")
    public ModelAndView getPageThymeleaf(@RequestParam(required=false) String name, @RequestParam String lastname) {
        String page = (name != null ) ? "pageThymeleaf" : "pageError";
        ModelAndView model = new ModelAndView(page);
        model.addObject("firstname", name);
        model.addObject("lastname", lastname);
        model.addObject("valori", "Valori passati dal client");
        model.addObject("method", "ModelAndView model");
        return model;
    }


}
