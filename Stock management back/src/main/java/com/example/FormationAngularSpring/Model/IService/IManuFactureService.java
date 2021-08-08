/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.FormationAngularSpring.Model.IService;

import com.example.FormationAngularSpring.Model.Entities.Manufacture;
import java.util.List;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface IManuFactureService {
    public List<Manufacture> getAllManufactures();
    public Manufacture createManufacture(Manufacture manufacture);
    public ResponseEntity<Manufacture> getManufactureById(int id);
    public ResponseEntity editManufacture(int id, Manufacture manufacture);
    public ResponseEntity<Map<String, Boolean>> deleteManufacture(int id);
}
