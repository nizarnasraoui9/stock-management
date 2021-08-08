/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.FormationAngularSpring.Controller;

import com.example.FormationAngularSpring.Model.Entities.Category;
import com.example.FormationAngularSpring.Model.Entities.SubCategory;
import com.example.FormationAngularSpring.Model.IService.ICategoryService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.example.FormationAngularSpring.Model.ServiceImp.CategoryServiceImpl;
import com.example.FormationAngularSpring.Model.ServiceImp.FileStorageService;
import filedemo.payload.UploadFileResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/categories")
public class CategoriesController {

    @Autowired
    private ICategoryService categorieService;

    @Autowired
    private FileStorageService fileStorageService;


    @GetMapping("/list")
    public ResponseEntity<List<Category>> getAllCategorys(@RequestParam(required = false) String title) {
        try {
            List<Category> categories = new ArrayList<Category>();

            if (title == null) {
                categorieService.getAllCategories().forEach(categories::add);
            } else {
                categorieService.getCategoriesByTitle(title).forEach(categories::add);
            }

            if (categories.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(categories, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value ="/new",consumes =MediaType.MULTIPART_FORM_DATA_VALUE)
    public UploadFileResponse createCategory(@RequestParam("photo") MultipartFile photo,@RequestParam String title) {
        String fileName=fileStorageService.storeFile(photo);
        String fileDownloadUri=ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/uploads/")
                .path(fileName)
                .toUriString();
        String url="/uploads/";
        url+=fileName;
        System.out.println(url);

        Category categorie=new Category();
        categorie.setTitle(title);


        categorie.setPhotoPath(url);
        categorieService.createCategory(categorie);
        return new UploadFileResponse(fileName, url,photo.getContentType(), photo.getSize());

    }

    @GetMapping("/categorie/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable int id) {
        return categorieService.getCategoryById(id);
    }

    @PutMapping("/categorie/{id}")
    public ResponseEntity<Category> editCategory(@PathVariable int id, @RequestBody Category categorie) {
        return categorieService.editCategory(id, categorie);
    }

    @DeleteMapping("/categorie/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteCategory(@PathVariable int id) {
        return categorieService.deleteCategory(id);
    }

}


   /* @GetMapping("/list")
   public ResponseEntity<List<Category>> getAllCategorys(@RequestParam(required = false) String title) {
        try {
            List<Category> categories = new ArrayList<Category>();

            if (title == null) {
                categorieService.getAllCategories().forEach(categories::add);
            } else {
                categorieService.getCategoriesByTitle(title).forEach(categories::add);
            }

            if (categories.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(categories, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping(value ="/new",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public UploadFileResponse createCategory(@RequestParam("photo") MultipartFile photo, @RequestParam String title) {
        String fileName=fileStorageService.storeFile(photo);
        String fileDownloadUri= ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/uploads/")
                .path(fileName)
                .toUriString();
        String url="/uploads/";
        url+=fileName;
        System.out.println(url);

        Category categorie=new Category();
        categorie.setTitle(title);


        categorie.setPhotoPath(url);
        categorieService.createCategory(categorie);
        return new UploadFileResponse(fileName, url,photo.getContentType(), photo.getSize());

    }





   /* @PostMapping(value ="/new",consumes={"application/json"})

    public Category createCategory(  @RequestBody Category categorie) {
        return categorieService.createCategory(categorie);
    }*/
//@PostMapping(value="/img")
//public ResponseEntity<MultipartFile> saveImgToDb(@RequestParam MultipartFile file){
       // return categorieService.saveImageToDB(file);
//}
   /* @GetMapping("/categorie/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable int id) {
        return categorieService.getCategoryById(id);
    }

    @PutMapping("/categorie/{id}")
    public ResponseEntity<Category> editCategory(@PathVariable int id, @RequestBody Category categorie) {
        return categorieService.editCategory(id, categorie);
    }

    @DeleteMapping("/categorie/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteCategory(@PathVariable int id) {
        return categorieService.deleteCategory(id);
    }
    
}*/
