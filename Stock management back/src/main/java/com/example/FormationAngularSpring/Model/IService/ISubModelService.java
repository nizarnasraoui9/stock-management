/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.FormationAngularSpring.Model.IService;

import com.example.FormationAngularSpring.Model.Entities.Model;
import com.example.FormationAngularSpring.Model.Entities.Submodel;
import java.util.List;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface ISubModelService {
    public List<Submodel> getAllSubmodels();
    public Submodel createSubmodel(Submodel subModel);
    public ResponseEntity<Submodel> getSubmodelById(int id);
    public ResponseEntity editSubmodel(int id, Submodel subModel);
    public ResponseEntity<Map<String, Boolean>> deleteSubmodel(int id);
    public List<Submodel> getSubModelsByName(String name);
}
