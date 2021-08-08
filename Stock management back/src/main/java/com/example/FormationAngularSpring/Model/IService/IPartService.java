/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.FormationAngularSpring.Model.IService;

import com.example.FormationAngularSpring.Model.Entities.Part;
import java.util.List;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface IPartService {
    public List<Part> getAllParts();
    public Part createPart(Part part);
    public ResponseEntity<Part> getPartById(int id);
    public ResponseEntity editPart(int id, Part part);
    public ResponseEntity<Map<String, Boolean>> deletePart(int id);
}
