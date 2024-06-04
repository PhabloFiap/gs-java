package com.monitoramento.marinho.GS.controller;

import com.monitoramento.marinho.GS.entity.User;
import com.monitoramento.marinho.GS.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuario")
public class UserController {


    @Autowired
    private UserService userService;

public UserController (UserService userService) {this.userService = userService;}

    @GetMapping
    List<User> listUser(){
        return userService.listUser();
    }

    @PostMapping("/registrar")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        User registeredUser = userService.createUser(user);
        return ResponseEntity.ok(registeredUser);
    }


    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return userService.getUserById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/usuario/{usuario}")
    public ResponseEntity<User> getUserByUsuario(@PathVariable String usuario) {
        return userService.GetUserByUsuario(usuario)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}