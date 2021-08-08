package com.example.FormationAngularSpring.Model.ServiceImp;



import com.example.FormationAngularSpring.Model.Entities.Manufacture;

import com.example.FormationAngularSpring.Model.IRepository.IManifactureRepository;
import com.example.FormationAngularSpring.Model.IService.IManuFactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ManufactureServiceImpl implements IManuFactureService {
    @Autowired
    private IManifactureRepository manufactureRepository;

    @Override
    public List<Manufacture> getAllManufactures() {
        return manufactureRepository.findAll();
    }

    @Override
    public Manufacture createManufacture(Manufacture manufacture) {
        return manufactureRepository.save(manufacture);
    }

    @Override
    public ResponseEntity<Manufacture> getManufactureById(int id) {
        Manufacture manufacture = manufactureRepository.findById(id).get();
        return ResponseEntity.ok(manufacture);
    }

    @Override
    public ResponseEntity editManufacture(int id, Manufacture manufacture) {
        Manufacture manufactureToEdit = manufactureRepository.findById(id).get();

        manufactureToEdit = manufacture;
        return ResponseEntity.ok(manufactureRepository.save(manufactureToEdit));
    }

    @Override
    public ResponseEntity<Map<String, Boolean>> deleteManufacture(int id) {
        Manufacture manufactureToDelete = manufactureRepository.findById(id).get();

        manufactureRepository.delete(manufactureToDelete);
        Map<String, Boolean> response = new HashMap();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
