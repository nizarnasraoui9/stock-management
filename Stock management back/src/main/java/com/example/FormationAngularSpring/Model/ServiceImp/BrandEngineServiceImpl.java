
package com.example.FormationAngularSpring.Model.ServiceImp;

import com.example.FormationAngularSpring.Model.Entities.BrandEngine;
import com.example.FormationAngularSpring.Model.IRepository.IBrandEngineRepository;
import com.example.FormationAngularSpring.Model.IService.IBrandEngineService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class BrandEngineServiceImpl implements IBrandEngineService{
    
    @Autowired
    private IBrandEngineRepository brandEngineRepository;
    
    @Override
    public List<BrandEngine> getAllBrandEngines() {
        return brandEngineRepository.findAll();
    }

    @Override
    public BrandEngine createBrandEngine(BrandEngine brandEngine) {
        return brandEngineRepository.save(brandEngine);
    }

    @Override
    public ResponseEntity<BrandEngine> getBrandEngineById(int id) {
        BrandEngine brandEngine = brandEngineRepository.findById(id).get();
        return ResponseEntity.ok(brandEngine);
    }

    @Override
    public ResponseEntity editBrandEngine(int id, BrandEngine brandEngine) {
        BrandEngine brandEngineToEdit = brandEngineRepository.findById(id).get();
        
        brandEngineToEdit = brandEngine;
        brandEngineToEdit.setId(id);
        return ResponseEntity.ok(brandEngineRepository.save(brandEngineToEdit));
    }

    @Override
    public ResponseEntity<Map<String, Boolean>> deleteBrandEngine(int id) {
        BrandEngine brandEngineToDelete = brandEngineRepository.findById(id).get();

        brandEngineRepository.delete(brandEngineToDelete);
        Map<String, Boolean> response = new HashMap();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

    
}
