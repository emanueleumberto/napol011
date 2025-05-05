package com.example.SpringWebRest.controllers;

import com.example.SpringWebRest.models.User;
import com.example.SpringWebRest.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired UserService userService;

    // GET | POST | PUT | PATCH | DELETE

    @GetMapping
    public List<User> getAllUser() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUser(@PathVariable Long id) {
        /*User user = userService.findUser(id);
        return user;*/
        try{
            return new ResponseEntity<User>(userService.findUser(id), HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody User user) {
        if(userService.checkEmail(user.getEmail()) == null) {
            return new ResponseEntity<User>(userService.saveUser(user), HttpStatus.CREATED);
        } else {
            return new ResponseEntity<String>("Duplicate entry " + user.getEmail(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody User user) {
        try{
            userService.findUser(id);
            if(id == user.getId()) {
                return new ResponseEntity<User>(userService.saveUser(user), HttpStatus.OK);
            } else {
                return new ResponseEntity<String>("Id not found!!", HttpStatus.NOT_FOUND);
            }
        } catch (NoSuchElementException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> updatePatchUser(@PathVariable Long id,
                                             @RequestBody Map<String, Object> updates) {

        User user;
        try{
            // Controllo se nel DB è presente un utente con l'ID passato da client
            user = userService.findUser(id);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
        }

        // Modifico le proprietà richieste dal Client
        updates.forEach((key, value) -> {
            // Cerco nella classe User una proprietà che ha lo stesso nome della chiave inviata dal client
            Field field = ReflectionUtils.findField(User.class, key);
            if(field != null) {
                // Rendo il campo accessibile per le modifiche
                field.setAccessible(true);
                // Modifico il campo richiesto nell'oggetto user con il valore inviato dal client
                ReflectionUtils.setField(field, user, value);
            }
        });
        return new ResponseEntity<User>(userService.saveUser(user), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id){
        try{
            User user = userService.findUser(id);
            return new ResponseEntity<String>(userService.removeUser(user), HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<?> deleteUserById(@PathVariable Long id){
        try{
            return new ResponseEntity<String>(userService.removeUserById(id), HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
