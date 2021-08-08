/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.FormationAngularSpring.Model.ServiceImp;

import com.example.FormationAngularSpring.Model.Entities.User;
import com.example.FormationAngularSpring.Model.IRepository.IUserRepository;
import com.example.FormationAngularSpring.Model.IService.IUserService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserRepository userRepository;
    
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public ResponseEntity<User> getUserById(int id) {
        User user = userRepository.findById(id).get();
        return ResponseEntity.ok(user);
    }

    @Override
    public ResponseEntity editUser(int id, User user) {
        User userToEdit = userRepository.findById(id).get();
        
        userToEdit = user;
        userToEdit.setId(id);
        return ResponseEntity.ok(userRepository.save(userToEdit));
    }

    @Override
    public ResponseEntity<Map<String, Boolean>> deleteUser(int id) {
        User userToDelete = userRepository.findById(id).get();

        userRepository.delete(userToDelete);
        Map<String, Boolean> response = new HashMap();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
    
}
