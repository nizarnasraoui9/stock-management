/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.FormationAngularSpring.Model.IService;

import com.example.FormationAngularSpring.Model.Entities.Brand;
import java.security.Provider;
import java.util.List;
import java.util.Map;

import com.example.FormationAngularSpring.Model.Entities.Category;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface IBrandService {
    public List<Brand> getAllBrands();
    public Brand createBrand(Brand brand);
    public ResponseEntity<Brand> getBrandById(int id);
    public ResponseEntity editBrand(int id, Brand brand);
    public ResponseEntity<Map<String, Boolean>> deleteBrand(int id);
    public List<Brand> getBrandsByName(String title);

}
