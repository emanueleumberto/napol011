package com.example.EsercizioGestioneProdotti.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DocController {

    @GetMapping("/")
    public String getDocumentation() {
        return "index";
    }

}
