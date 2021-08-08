/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.FormationAngularSpring.Model.ServiceImp;

import com.example.FormationAngularSpring.Model.Entities.SubCategory;
import com.example.FormationAngularSpring.Model.IRepository.ISubCategoryRepository;
import com.example.FormationAngularSpring.Model.IService.ISubCategoryService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class SubCategoryServiceImpl implements ISubCategoryService {

    @Autowired
    private ISubCategoryRepository subCategoryRepository;
    
    @Override
    public List<SubCategory> getAllSubCategories() {
        return subCategoryRepository.findAll();
    }

    @Override
    public SubCategory createSubCategory(SubCategory categoy) {
        return subCategoryRepository.save(categoy);
    }

    @Override
    public ResponseEntity<SubCategory> getSubCategoryById(int id) {
        SubCategory categoy = subCategoryRepository.findById(id).get();
        return ResponseEntity.ok(categoy);
    }

    @Override
    public ResponseEntity editSubCategory(int id, SubCategory subCategory) {
        SubCategory subCategoryToEdit = subCategoryRepository.findById(id).get();
        
        subCategoryToEdit = subCategory;
        subCategoryToEdit.setId(id);
        return ResponseEntity.ok(subCategoryRepository.save(subCategoryToEdit));
    }

    @Override
    public ResponseEntity<Map<String, Boolean>> deleteSubCategory(int id) {
        SubCategory categoyToDelete = subCategoryRepository.findById(id).get();

        subCategoryRepository.delete(categoyToDelete);
        Map<String, Boolean> response = new HashMap();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

    @Override
    public List<SubCategory> getSubCategoriesByTitle(String title) {
        return subCategoryRepository.getSubCategoriesByTitle(title);
    }

    @Override
    public SubCategory findSubCategoryById(int id) {
        return subCategoryRepository.getById(id);
    }
    
}
