/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.FormationAngularSpring.Model.ServiceImp;

import com.example.FormationAngularSpring.Model.Entities.Category;
import com.example.FormationAngularSpring.Model.IRepository.ICategoryRepository;
import com.example.FormationAngularSpring.Model.IService.ICategoryService;

import java.io.IOException;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    private ICategoryRepository categoryRepository;
    
    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

   @Override
    public Category createCategory(Category categoy) {
       return categoryRepository.save(categoy);}





/*MultipartFile file = null;
       // saveImageToDB(MultipartFile file) {

            Category c = new Category();
            String fileName = StringUtils.cleanPath(file.getOriginalFilename());
            if (fileName.contains("..")) {
                System.out.println("not a a valid file");
            }
            try {
                c.setImage(Base64.getEncoder().encodeToString(file.getBytes())); ;
            } catch (IOException e) {
                e.printStackTrace();
            }
            //return null;
        return categoryRepository.save(categoy);
        }*/


   /* public void saveCatToDB(MultipartFile file, String title)
    {
        Category c = new Category();
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        if(fileName.contains(".."))
        {
            System.out.println("not a a valid file");
        }
        try {
            c.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }


        c.setTitle(title);

        categoryRepository.save(c);
    }*/






    @Override
    public ResponseEntity<Category> getCategoryById(int id) {
        Category categoy = categoryRepository.findById(id).get();
        return ResponseEntity.ok(categoy);
    }

    @Override
    public ResponseEntity editCategory(int id, Category category) {
        Category categoryToEdit = categoryRepository.findById(id).get();
        
        categoryToEdit = category;
        return ResponseEntity.ok(categoryRepository.save(categoryToEdit));
    }

    @Override
    public ResponseEntity<Map<String, Boolean>> deleteCategory(int id) {
        Category categoyToDelete = categoryRepository.findById(id).get();

        categoryRepository.delete(categoyToDelete);
        Map<String, Boolean> response = new HashMap();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

    @Override
    public List<Category> getCategoriesByTitle(String title) {
        return categoryRepository.getCategoriesByTitle(title);
    }

    @Override
    public Category getCategoryBuId(int id) {
        return categoryRepository.getById(id);
    }




    /*public ResponseEntity<MultipartFile> saveImageToDB(MultipartFile file) {

        Category c = new Category();
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        if (fileName.contains("..")) {
            System.out.println("not a a valid file");
        }
        try {
            c.setImage(Base64.getEncoder().encodeToString(file.getBytes())); ;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }*/
    
}
