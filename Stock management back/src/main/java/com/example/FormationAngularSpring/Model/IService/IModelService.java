/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.FormationAngularSpring.Model.IService;

import com.example.FormationAngularSpring.Model.Entities.Model;
import java.util.List;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public interface IModelService {
    public List<Model> getAllModels();
    public Model createModel(Model model);
    public ResponseEntity<Model> getModelById(int id);
    public ResponseEntity editModel(int id, Model model);
    public ResponseEntity<Map<String, Boolean>> deleteModel(int id);
    public List<Model> getModelsByName(String name);
}
