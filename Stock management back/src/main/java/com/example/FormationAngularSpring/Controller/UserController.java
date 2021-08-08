/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.FormationAngularSpring.Controller;

import com.example.FormationAngularSpring.Model.Entities.User;
import com.example.FormationAngularSpring.Model.IService.IUserService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/users")
public class UserController {
    
    @Autowired
    private IUserService userService;
    
    @GetMapping("/list")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }
    
    @PostMapping("/new")
    public User createUser(@RequestBody User user){
        return userService.createUser(user);       
    }
    
    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable int id){
        return userService.getUserById(id);
    }
    
    @PutMapping("/user/{id}")
    public ResponseEntity<User> editUser(@PathVariable int id, @RequestBody User user){
       return userService.editUser(id, user);
    }
    
    @DeleteMapping("/user/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteUser(@PathVariable int id){
        return userService.deleteUser(id);
    }
    
    
    
}
