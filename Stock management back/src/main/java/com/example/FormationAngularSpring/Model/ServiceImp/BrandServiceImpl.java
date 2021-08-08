/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.FormationAngularSpring.Model.ServiceImp;

import com.example.FormationAngularSpring.Model.Entities.Brand;
import com.example.FormationAngularSpring.Model.Entities.Category;
import com.example.FormationAngularSpring.Model.IRepository.IBrandRepository;
import com.example.FormationAngularSpring.Model.IService.IBrandService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class BrandServiceImpl implements IBrandService {

    @Autowired
    private IBrandRepository brandRepository;
    
    @Override
    public List<Brand> getAllBrands() {
        return brandRepository.findAll();
    }

    @Override
    public Brand createBrand(Brand brand) {
        return brandRepository.save(brand);
    }

    @Override
    public ResponseEntity<Brand> getBrandById(int id) {
        Brand brand = brandRepository.findById(id).get();
        return ResponseEntity.ok(brand);
    }

    @Override
    public ResponseEntity editBrand(int id, Brand brand) {
        Brand brandToEdit = brandRepository.findById(id).get();
        
        brandToEdit = brand;
        brandToEdit.setId(id);
        return ResponseEntity.ok(brandRepository.save(brandToEdit));
    }

    @Override
    public ResponseEntity<Map<String, Boolean>> deleteBrand(int id) {
        Brand brandToDelete = brandRepository.findById(id).get();

        brandRepository.delete(brandToDelete);
        Map<String, Boolean> response = new HashMap();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

    @Override
    public List<Brand> getBrandsByName(String name) {
        return brandRepository.getBrandsByName(name);
    }



}
