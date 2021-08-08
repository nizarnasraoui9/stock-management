/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.FormationAngularSpring.Model.IService;

import com.example.FormationAngularSpring.Model.Entities.Inventory;
import java.util.List;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface IInventoryService {
    public List<Inventory> getAllInventorys();
    public Inventory createInventory(Inventory inventory);
    public ResponseEntity<Inventory> getInventoryById(int id);
    public ResponseEntity editInventory(int id, Inventory inventory);
    public ResponseEntity<Map<String, Boolean>> deleteInventory(int id);
}
