/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.FormationAngularSpring.Controller;

import com.example.FormationAngularSpring.Model.Entities.Brand;
import com.example.FormationAngularSpring.Model.IService.IBrandService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/brands")
public class BrandController {
    
    @Autowired
    private IBrandService brandrService;
    
    @GetMapping("/list")
    public List<Brand> getAllBrands(){
        return brandrService.getAllBrands();
    }
    
    @PostMapping("/new")
    public Brand createBrand(@RequestBody Brand brandr){
        return brandrService.createBrand(brandr);       
    }
    
    @GetMapping("/brand/{id}")
    public ResponseEntity<Brand> getBrandById(@PathVariable int id){
        return brandrService.getBrandById(id);
    }
    
    @PutMapping("/brand/{id}")
    public ResponseEntity<Brand> editBrand(@RequestBody Brand brandr){
       return brandrService.editBrand(brandr.getId(), brandr);
    }
    
    @DeleteMapping("/brand/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteBrand(@PathVariable int id){
        return brandrService.deleteBrand(id);
    }
    
    
    
}
