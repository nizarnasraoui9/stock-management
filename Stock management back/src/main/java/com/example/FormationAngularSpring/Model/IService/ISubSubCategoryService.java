/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.FormationAngularSpring.Model.IService;

import com.example.FormationAngularSpring.Model.Entities.SubCategory;
import com.example.FormationAngularSpring.Model.Entities.SubSubCategory;
import java.util.List;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface ISubSubCategoryService {
    public List<SubSubCategory> getAllSubSubCategorys();
    public SubSubCategory createSubSubCategory(SubSubCategory subSubCategory);
    public ResponseEntity<SubSubCategory> getSubSubCategoryById(int id);
    public ResponseEntity editSubSubCategory(int id, SubSubCategory subSubCategory);
    public ResponseEntity<Map<String, Boolean>> deleteSubSubCategory(int id);
    public List<SubSubCategory> getSubsubCategoriesByTitle(String title);
}
