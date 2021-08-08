package com.example.FormationAngularSpring.Controller;

import com.example.FormationAngularSpring.Model.Entities.Model;
import com.example.FormationAngularSpring.Model.Entities.Submodel;
import com.example.FormationAngularSpring.Model.IService.IModelService;
import com.example.FormationAngularSpring.Model.IService.ISubModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/submodels")
public class SubmodelController {
    @Autowired
    private ISubModelService submodelService;




//    @GetMapping("/list")
//    public List<SubCategory> getAllCategories() {
//        return subCategoryService.getAllCategories();
//    }

    @GetMapping("/list")
    public ResponseEntity<List<Submodel>> getAllSubModels(@RequestParam(required = false) String name) {
        try {
            List<Submodel> submodels = new ArrayList<Submodel>();

            if (name == null) {
                submodelService.getAllSubmodels().forEach(submodels::add);
            } else {
                submodelService.getSubModelsByName(name).forEach(submodels::add);
            }

            if (submodels.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(submodels, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/new")
    public Submodel createSubmoodel(@RequestBody Submodel submodel) {

        return submodelService.createSubmodel(submodel);
    }

    @GetMapping("/submodel/{id}")
    public ResponseEntity<Submodel> getSubmodelById(@PathVariable int id) {
        return submodelService.getSubmodelById(id);
    }

    @PutMapping("/submodel/{id}")
    public ResponseEntity<Submodel> editSubmodel(@PathVariable int id, @RequestBody Submodel submodel) {
        return submodelService.editSubmodel(id, submodel);
    }

    @DeleteMapping("/submodel/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteSubmodel(@PathVariable int id) {

        return submodelService.deleteSubmodel(id);
    }

}






