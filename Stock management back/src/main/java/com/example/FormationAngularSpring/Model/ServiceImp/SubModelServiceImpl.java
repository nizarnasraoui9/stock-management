package com.example.FormationAngularSpring.Model.ServiceImp;

import com.example.FormationAngularSpring.Model.Entities.Model;
import com.example.FormationAngularSpring.Model.Entities.Submodel;
import com.example.FormationAngularSpring.Model.IRepository.IModelRepository;
import com.example.FormationAngularSpring.Model.IRepository.ISubModelRepository;
import com.example.FormationAngularSpring.Model.IService.ISubModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SubModelServiceImpl implements ISubModelService {

    @Autowired
    private ISubModelRepository submodelRepository;

    public List<Submodel> getAllSubmodels() {
        return submodelRepository.findAll();
    }

    @Override
    public Submodel createSubmodel(Submodel submodel) {
        return submodelRepository.save(submodel);
    }

    @Override
    public ResponseEntity<Submodel> getSubmodelById(int id) {
        Submodel submodel = submodelRepository.findById(id).get();
        return ResponseEntity.ok(submodel);
    }

    @Override
    public ResponseEntity editSubmodel(int id, Submodel submodel) {
        Submodel submodelToEdit = submodelRepository.findById(id).get();

        submodelToEdit = submodel;
        return ResponseEntity.ok(submodelRepository.save(submodelToEdit));
    }

    @Override
    public ResponseEntity<Map<String, Boolean>> deleteSubmodel(int id) {
        Submodel submodelToDelete = submodelRepository.findById(id).get();

        submodelRepository.delete(submodelToDelete);
        Map<String, Boolean> response = new HashMap();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

    @Override
    public List<Submodel> getSubModelsByName(String name) {

        return submodelRepository.getSubModelsByName(name);

    }
}

