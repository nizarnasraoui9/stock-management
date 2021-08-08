package com.example.FormationAngularSpring.Model.ServiceImp;

import com.example.FormationAngularSpring.Model.Entities.Model;
import com.example.FormationAngularSpring.Model.IRepository.IModelRepository;
import com.example.FormationAngularSpring.Model.IService.IModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ModelServiceImpl implements IModelService {

    @Autowired
    private IModelRepository modelRepository;

    public List<Model> getAllModels() {
        return modelRepository.findAll();
    }

    @Override
    public Model createModel(Model model) {
        return modelRepository.save(model);
    }

    @Override
    public ResponseEntity<Model> getModelById(int id) {
        Model model = modelRepository.findById(id).get();
        return ResponseEntity.ok(model);
    }

    @Override
    public ResponseEntity editModel(int id, Model model) {
        Model modelToEdit = modelRepository.findById(id).get();

        modelToEdit = model;
        return ResponseEntity.ok(modelRepository.save(modelToEdit));
    }

    @Override
    public ResponseEntity<Map<String, Boolean>> deleteModel(int id) {
        Model modelToDelete = modelRepository.findById(id).get();

        modelRepository.delete(modelToDelete);
        Map<String, Boolean> response = new HashMap();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

    @Override
    public List<Model> getModelsByName(String name) {

            return modelRepository.getModelsByName(name);

    }
}
