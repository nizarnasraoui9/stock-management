/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.FormationAngularSpring.Model.IService;

import com.example.FormationAngularSpring.Model.Entities.Engine;
import java.util.List;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface IEngineService {
    public List<Engine> getAllEngines();
    public Engine createEngine(Engine engine);
    public ResponseEntity<Engine> getEngineById(int id);
    public ResponseEntity editEngine(int id, Engine engine);
    public ResponseEntity<Map<String, Boolean>> deleteEngine(int id);
}
