/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.FormationAngularSpring.Model.ServiceImp;

import com.example.FormationAngularSpring.Model.Entities.Inventory;
import com.example.FormationAngularSpring.Model.IRepository.IInventoryRepository;
import com.example.FormationAngularSpring.Model.IService.IInventoryService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class InventoryServiceImpl implements IInventoryService {

    @Autowired
    private IInventoryRepository inventoryRepository;
    
    @Override
    public List<Inventory> getAllInventorys() {
        return inventoryRepository.findAll();
    }

    @Override
    public Inventory createInventory(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

    @Override
    public ResponseEntity<Inventory> getInventoryById(int id) {
        Inventory inventory = inventoryRepository.findById(id).get();
        return ResponseEntity.ok(inventory);
    }

    @Override
    public ResponseEntity editInventory(int id, Inventory inventory) {
        Inventory inventoryToEdit = inventoryRepository.findById(id).get();
        
        inventoryToEdit = inventory;
        inventoryToEdit.setId(id);
        return ResponseEntity.ok(inventoryRepository.save(inventoryToEdit));
    }

    @Override
    public ResponseEntity<Map<String, Boolean>> deleteInventory(int id) {
        Inventory inventoryToDelete = inventoryRepository.findById(id).get();

        inventoryRepository.delete(inventoryToDelete);
        Map<String, Boolean> response = new HashMap();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
    
}
