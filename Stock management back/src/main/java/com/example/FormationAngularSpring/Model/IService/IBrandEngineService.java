/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.FormationAngularSpring.Model.IService;

import com.example.FormationAngularSpring.Model.Entities.BrandEngine;
import java.util.List;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface IBrandEngineService {
    public List<BrandEngine> getAllBrandEngines();
    public ResponseEntity<BrandEngine> getBrandEngineById(int id);
    public BrandEngine createBrandEngine(BrandEngine brandEngine);
    public ResponseEntity<BrandEngine> editBrandEngine(int id, BrandEngine brandEngine);
    public ResponseEntity<Map<String, Boolean>> deleteBrandEngine(int id);
}
