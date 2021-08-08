/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.FormationAngularSpring.Model.ServiceImp;

import com.example.FormationAngularSpring.Model.Entities.Engine;
import com.example.FormationAngularSpring.Model.IRepository.IEngineRepository;
import com.example.FormationAngularSpring.Model.IService.IEngineService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EngineServiceImpl implements IEngineService {

    @Autowired
    private IEngineRepository engineRepository;
    
    @Override
    public List<Engine> getAllEngines() {
        return engineRepository.findAll();
    }

    @Override
    public Engine createEngine(Engine engine) {
        return engineRepository.save(engine);
    }

    @Override
    public ResponseEntity<Engine> getEngineById(int id) {
        Engine engine = engineRepository.findById(id).get();
        return ResponseEntity.ok(engine);
    }

    @Override
    public ResponseEntity editEngine(int id, Engine engine) {
        Engine engineToEdit = engineRepository.findById(id).get();
        
        engineToEdit = engine;
        engineToEdit.setId(id);
        return ResponseEntity.ok(engineRepository.save(engineToEdit));
    }

    @Override
    public ResponseEntity<Map<String, Boolean>> deleteEngine(int id) {
        Engine engineToDelete = engineRepository.findById(id).get();

        engineRepository.delete(engineToDelete);
        Map<String, Boolean> response = new HashMap();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
    
}
