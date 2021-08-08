/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.FormationAngularSpring.Model.IService;

import com.example.FormationAngularSpring.Model.Entities.SubCategory;
import java.util.List;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface ISubCategoryService {
    public List<SubCategory> getAllSubCategories();
    public SubCategory createSubCategory(SubCategory subCategory);
    public ResponseEntity<SubCategory> getSubCategoryById(int id);
    public ResponseEntity editSubCategory(int id, SubCategory subCategory);
    public ResponseEntity<Map<String, Boolean>> deleteSubCategory(int id);
    public List<SubCategory> getSubCategoriesByTitle(String title);
    public SubCategory findSubCategoryById(int id);
}
