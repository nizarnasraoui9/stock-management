/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.FormationAngularSpring.Model.IService;

import com.example.FormationAngularSpring.Model.Entities.Movement;
import java.util.List;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface IMovementService {
    public List<Movement> getAllMovements();
    public Movement createMovement(Movement movement);
    public ResponseEntity<Movement> getMovementById(int id);
    public ResponseEntity editMovement(int id, Movement movement);
    public ResponseEntity<Map<String, Boolean>> deleteMovement(int id);
}
