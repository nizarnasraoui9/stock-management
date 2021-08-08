/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.FormationAngularSpring.Model.IService;

import com.example.FormationAngularSpring.Model.Entities.Brand;
import com.example.FormationAngularSpring.Model.Entities.Image;
import com.example.FormationAngularSpring.Model.Entities.Manufacture;
import com.example.FormationAngularSpring.Model.Entities.Part;
import java.util.List;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface IImageService {
    public Image getPartImage(Part part);
    public Image getBrandImage(Brand brand);
    public Image getManufactureImage(Manufacture manufacture);
    public List<Image> getAllImages();
    public Image createImage(Image image);
    public ResponseEntity<Image> getImageById(int id);
    public ResponseEntity editImage(int id, Image image);
    public ResponseEntity<Map<String, Boolean>> deleteImage(int id);
}
