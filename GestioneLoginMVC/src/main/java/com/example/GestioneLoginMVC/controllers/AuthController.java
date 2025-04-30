package com.example.GestioneLoginMVC.controllers;

import com.example.GestioneLoginMVC.dto.UtenteDTO;
import com.example.GestioneLoginMVC.models.Utente;
import com.example.GestioneLoginMVC.services.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AuthController {

    @Autowired UtenteService utenteService;

    //GET /login: mostra form login
    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    //GET /register: mostra form registrazione
    @GetMapping("/register")
    public String registerPage(Model model) {
        model.addAttribute("utente", new UtenteDTO());
        return "register";
    }

    //GET /dashboard: mostra la pagina protetta
    @GetMapping("/dashboard")
    public String dashboardPage(@ModelAttribute("utente") Utente utente) {
        if(utente.getId() == null) return "redirect:/login";
        return "dashboard";
    }

    //POST /register: valida e registra
    @PostMapping("/register")
    public String registerController(@ModelAttribute("utente") UtenteDTO utente, RedirectAttributes redirect) {
        utenteService.registerUser(utente);
        return "redirect:login";
    }

    //POST /login: valida e autentica
    @PostMapping("/login")
    public String loginController(Model model, @RequestParam String email, @RequestParam String password, RedirectAttributes redirect) {
        Utente utente = utenteService.authenticateUser(email, password);
        System.out.println(utente);
        if(utente == null) {
            model.addAttribute("error", "Credenziali non valide");
            return "login";
        }
        redirect.addFlashAttribute("utente", utente);
        return "redirect:dashboard";
    }
}
