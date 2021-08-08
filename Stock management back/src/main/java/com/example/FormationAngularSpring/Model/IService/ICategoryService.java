/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.FormationAngularSpring.Model.IService;

import com.example.FormationAngularSpring.Model.Entities.Category;

import java.util.List;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface ICategoryService {
    public List<Category> getAllCategories();
    public Category createCategory(Category category);
    public ResponseEntity<Category> getCategoryById(int id);
    public ResponseEntity editCategory(int id, Category category);
    public ResponseEntity<Map<String, Boolean>> deleteCategory(int id);
    public List<Category> getCategoriesByTitle(String title);
    public Category getCategoryBuId(int id);
    //public void saveCatToDB(MultipartFile file ,String  title);
    
}
