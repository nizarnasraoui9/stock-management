package com.example.FormationAngularSpring.Controller;

import com.example.FormationAngularSpring.Model.Entities.Brand;
import com.example.FormationAngularSpring.Model.Entities.BrandEngine;
import com.example.FormationAngularSpring.Model.IService.IBrandEngineService;
import com.example.FormationAngularSpring.Model.IService.IBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/brandEngine")
public class BrandEngineController {
    @Autowired
    private IBrandEngineService brandEngineService;

    @GetMapping("/list")
    public List<BrandEngine> getAllBrandEngines(){
        return brandEngineService.getAllBrandEngines();
    }

    @PostMapping("/new")
    public BrandEngine createBrandEngine(@RequestBody BrandEngine brandEngine){
        return brandEngineService.createBrandEngine(brandEngine);
    }

    @GetMapping("/brandEngine/{id}")
    public ResponseEntity<BrandEngine> getBrandEngineById(@PathVariable int id){
        return brandEngineService.getBrandEngineById(id);
    }

    @PutMapping("/brandEngine/{id}")
    public ResponseEntity<BrandEngine> editBrandEngine(@RequestBody BrandEngine brandEngine){
        return brandEngineService.editBrandEngine(brandEngine.getId(), brandEngine);
    }

    @DeleteMapping("/brandEngine/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteBrandEngine(@PathVariable int id){
        return brandEngineService.deleteBrandEngine(id);
    }



}