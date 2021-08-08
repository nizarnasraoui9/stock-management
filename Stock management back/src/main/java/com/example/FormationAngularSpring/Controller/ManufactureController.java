package com.example.FormationAngularSpring.Controller;


import com.example.FormationAngularSpring.Model.Entities.Manufacture;
import com.example.FormationAngularSpring.Model.IService.IManuFactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;



@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/manufactures")
public class ManufactureController {

        @Autowired
        private IManuFactureService manufactureService;


        @GetMapping("/list")
        public ResponseEntity<List<Manufacture>> getAllManufactures(@RequestParam(required = false) String name) {
            try {
                List<Manufacture> manufactures = new ArrayList<Manufacture>();

                if (name == null) {
                    manufactureService.getAllManufactures().forEach(manufactures::add);
                }
                if (manufactures.isEmpty()) {
                    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                }

                return new ResponseEntity<>(manufactures, HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        @PostMapping("/new")
        public Manufacture createManufacture(@RequestBody Manufacture manufacture) {
            return manufactureService.createManufacture(manufacture);
        }

        @GetMapping("/manufacture/{id}")
        public ResponseEntity<Manufacture> getManufactureById(@PathVariable int id) {
            return manufactureService.getManufactureById(id);
        }

        @PutMapping("/manufacture/{id}")
        public ResponseEntity<Manufacture> editManufacture(@PathVariable int id, @RequestBody Manufacture manufacture) {
            return manufactureService.editManufacture(id, manufacture);
        }

        @DeleteMapping("/manufacture/{id}")
        public ResponseEntity<Map<String, Boolean>> deleteManufacture(@PathVariable int id) {
            return manufactureService.deleteManufacture(id);
        }

    }

