package com.example.FormationAngularSpring.Controller;

import com.example.FormationAngularSpring.Model.Entities.Model;

import com.example.FormationAngularSpring.Model.IRepository.IModelRepository;
import com.example.FormationAngularSpring.Model.IService.IModelService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


    @RestController
    @CrossOrigin(origins = "*")
    @RequestMapping("/models")

    public class ModelController {
        @Autowired
        private IModelService modelService;



        @Autowired
        private IModelRepository modelRepository;
//    @GetMapping("/list")
//    public List<SubCategory> getAllCategories() {
//        return subCategoryService.getAllCategories();
//    }

        @GetMapping("/list")
        public ResponseEntity<List<Model>> getAllModels(@RequestParam(required = false) String name) {
            try {
                List<Model> models = new ArrayList<Model>();

                if (name == null) {
                    modelService.getAllModels().forEach(models::add);
                } else {
                    modelService.getModelsByName(name).forEach(models::add);
                }

                if (models.isEmpty()) {
                    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                }

                return new ResponseEntity<>(models, HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        @PostMapping("/new")
        public Model createModel(@RequestBody Model model) {

            return modelService.createModel(model);
        }

        @GetMapping("/model/{id}")
        public ResponseEntity<Model> getModelById(@PathVariable int id) {
            return modelService.getModelById(id);
        }

        @PutMapping("/model/{id}")
        public ResponseEntity<Model> editModel(@PathVariable int id, @RequestBody Model model) {
            return modelService.editModel(id, model);
        }

        @DeleteMapping("/model/{id}")
        public ResponseEntity<Map<String, Boolean>> deleteModel(@PathVariable int id) {

            return modelService.deleteModel(id);
        }





    }




