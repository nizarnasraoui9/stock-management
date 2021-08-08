/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.FormationAngularSpring.Model.IService;

import com.example.FormationAngularSpring.Model.Entities.User;
import java.util.List;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public interface IUserService {
    public List<User> getAllUsers();
    public User createUser(User user);
    public ResponseEntity<User> getUserById(int id);
    public ResponseEntity editUser(int id, User user);
    public ResponseEntity<Map<String, Boolean>> deleteUser(int id);
}
