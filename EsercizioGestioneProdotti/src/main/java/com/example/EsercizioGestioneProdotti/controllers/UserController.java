package com.example.EsercizioGestioneProdotti.controllers;

import com.example.EsercizioGestioneProdotti.models.User;
import com.example.EsercizioGestioneProdotti.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired UserService userService;


    @GetMapping
    public List<User> getAllUsers() {
        // GET /users → Restituisce tutti gli utenti.
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        // GET /users/{id} → Restituisce un utente.
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        // POST /users → Registra un nuovo utente.
        return ResponseEntity.ok(userService.saveUser(user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok("User deleted!!");
    }


}
