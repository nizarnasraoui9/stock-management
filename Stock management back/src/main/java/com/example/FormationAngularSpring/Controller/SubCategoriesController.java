/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.FormationAngularSpring.Controller;

import com.example.FormationAngularSpring.Model.Entities.Category;
import com.example.FormationAngularSpring.Model.Entities.SubCategory;
import com.example.FormationAngularSpring.Model.IService.ICategoryService;
import com.example.FormationAngularSpring.Model.IService.ISubCategoryService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/subcategories")
public class SubCategoriesController {

    @Autowired
    private ISubCategoryService subCategoryService;

    @Autowired
    private ICategoryService categorySrvice;

//    @GetMapping("/list")
//    public List<SubCategory> getAllCategories() {
//        return subCategoryService.getAllCategories();
//    }

    @GetMapping("/list")
    public ResponseEntity<List<SubCategory>> getAllSubCategories(@RequestParam(required = false) String title) {
        try {
            List<SubCategory> categories = new ArrayList<SubCategory>();

            if (title == null) {
                subCategoryService.getAllSubCategories().forEach(categories::add);
            } else {
                subCategoryService.getSubCategoriesByTitle(title).forEach(categories::add);
            }

            if (categories.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(categories, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/new")
    public SubCategory createSubCategory(@RequestBody SubCategory subcategorie) {
       
        return subCategoryService.createSubCategory(subcategorie);
    }

    @GetMapping("/subcategorie/{id}")
    public ResponseEntity<SubCategory> getSubCategoryById(@PathVariable int id) {
        return subCategoryService.getSubCategoryById(id);
    }

    @PutMapping("/subcategorie/{id}")
    public ResponseEntity<SubCategory> editSubCategory(@PathVariable int id, @RequestBody SubCategory categorie) {
        return subCategoryService.editSubCategory(id, categorie);
    }

    @DeleteMapping("/subcategorie/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteSubCategory(@PathVariable int id) {
        
        return subCategoryService.deleteSubCategory(id);
    }

}
