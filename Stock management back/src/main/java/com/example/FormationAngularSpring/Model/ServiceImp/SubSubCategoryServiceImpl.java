package com.example.FormationAngularSpring.Model.ServiceImp;

import com.example.FormationAngularSpring.Model.Entities.SubSubCategory;

import com.example.FormationAngularSpring.Model.IRepository.ISubSubCategoryRepository;
import com.example.FormationAngularSpring.Model.IService.ISubSubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SubSubCategoryServiceImpl implements ISubSubCategoryService {
    @Autowired
    private ISubSubCategoryRepository SubSubCategoryRepository;

    @Override
    public List<SubSubCategory> getAllSubSubCategorys() {
        return SubSubCategoryRepository.findAll();
    }

    @Override
    public SubSubCategory createSubSubCategory(SubSubCategory subSubCategory) {
        return SubSubCategoryRepository.save(subSubCategory);
    }

    @Override
    public ResponseEntity<SubSubCategory> getSubSubCategoryById(int id) {
        SubSubCategory subsubcategory = SubSubCategoryRepository.findById(id).get();
        return ResponseEntity.ok(subsubcategory);
    }

    @Override
    public ResponseEntity editSubSubCategory(int id, SubSubCategory subSubCategory) {
        SubSubCategory subsubCategoryToEdit = SubSubCategoryRepository.findById(id).get();

        subsubCategoryToEdit = subSubCategory;
        subsubCategoryToEdit.setId(id);
        return ResponseEntity.ok(SubSubCategoryRepository.save(subsubCategoryToEdit));
    }

    @Override
    public ResponseEntity<Map<String, Boolean>> deleteSubSubCategory(int id) {
        SubSubCategory subsubcategoryToDelete = SubSubCategoryRepository.findById(id).get();

        SubSubCategoryRepository.delete(subsubcategoryToDelete);
        Map<String, Boolean> response = new HashMap();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

    @Override
    public List<SubSubCategory> getSubsubCategoriesByTitle(String title) {
        return SubSubCategoryRepository.getSubsubCategoriesByTitle(title);
    }
}
