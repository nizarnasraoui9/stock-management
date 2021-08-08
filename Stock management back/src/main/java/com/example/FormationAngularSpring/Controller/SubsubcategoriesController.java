package com.example.FormationAngularSpring.Controller;

import com.example.FormationAngularSpring.Model.Entities.SubSubCategory;
import com.example.FormationAngularSpring.Model.IService.ISubCategoryService;
import com.example.FormationAngularSpring.Model.IService.ISubSubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/subsubcategories")

public class SubsubcategoriesController {
    @Autowired
    private ISubCategoryService subCategoryService;
    @Autowired
    private ISubSubCategoryService subsubCategoryService;



//    @GetMapping("/list")
//    public List<SubCategory> getAllCategories() {
//        return subCategoryService.getAllCategories();
//    }

    @GetMapping("/list")
    public ResponseEntity<List<SubSubCategory>> getAllSubsubCategories(@RequestParam(required = false) String title) {
        try {
            List<SubSubCategory> subsubcategories = new ArrayList<SubSubCategory>();

            if (title == null) {
                subsubCategoryService.getAllSubSubCategorys().forEach(subsubcategories::add);
            } else {
                subsubCategoryService.getSubsubCategoriesByTitle(title).forEach(subsubcategories::add);
            }

            if (subsubcategories.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(subsubcategories, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/new")
    public SubSubCategory createSubSubCategory(@RequestBody SubSubCategory subsubcategory) {

        return subsubCategoryService.createSubSubCategory(subsubcategory);
    }

    @GetMapping("/subsubcategorie/{id}")
    public ResponseEntity<SubSubCategory> getSubSubCategoryById(@PathVariable int id) {
        return subsubCategoryService.getSubSubCategoryById(id);
    }

    @PutMapping("/subsubcategorie/{id}")
    public ResponseEntity<SubSubCategory> editSubSubCategory(@PathVariable int id, @RequestBody SubSubCategory subsubcategorie) {
        return subsubCategoryService.editSubSubCategory(id, subsubcategorie);
    }

    @DeleteMapping("/subsubcategorie/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteSubSubCategory(@PathVariable int id) {

        return subsubCategoryService.deleteSubSubCategory(id);
    }

}


