/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.FormationAngularSpring.Model.IService;

import com.example.FormationAngularSpring.Model.Entities.LineInventory;
import java.util.List;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface ILineInventoryService {
    public List<LineInventory> getAllLineInventorys();
    public LineInventory createLineInventory(LineInventory lineInventory);
    public ResponseEntity<LineInventory> getLineInventoryById(int id);
    public ResponseEntity editLineInventory(int id, LineInventory lineInventory);
    public ResponseEntity<Map<String, Boolean>> deleteLineInventory(int id);
}
