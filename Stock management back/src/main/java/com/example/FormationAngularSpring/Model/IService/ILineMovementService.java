/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.FormationAngularSpring.Model.IService;

import com.example.FormationAngularSpring.Model.Entities.LineMovement;
import java.util.List;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface ILineMovementService {
    public List<LineMovement> getAllLineMovements();
    public LineMovement createLineMovement(LineMovement lineMovement);
    public ResponseEntity<LineMovement> getLineMovementById(int id);
    public ResponseEntity editLineMovement(int id, LineMovement lineMovement);
    public ResponseEntity<Map<String, Boolean>> deleteLineMovement(int id);
}
