package com.example.FormationAngularSpring.Controller;

import com.example.FormationAngularSpring.Model.Entities.Engine;
import com.example.FormationAngularSpring.Model.Entities.Manufacture;
import com.example.FormationAngularSpring.Model.IService.IEngineService;
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
@RequestMapping("/engines")
public class EngineController {


    @Autowired
    private IEngineService engineService;


    @GetMapping("/list")
    public ResponseEntity<List<Engine>> getAllEngines(@RequestParam(required = false) String name) {
        try {
            List<Engine> engines = new ArrayList<Engine>();

            if (name == null) {
                engineService.getAllEngines().forEach(engines::add);
            }
            if (engines.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(engines, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/new")
    public Engine createEngine(@RequestBody Engine engine) {
        return engineService.createEngine(engine);
    }

    @GetMapping("/engine/{id}")
    public ResponseEntity<Engine> getEngineById(@PathVariable int id) {
        return engineService.getEngineById(id);
    }

    @PutMapping("/engine/{id}")
    public ResponseEntity<Engine> editEngine(@PathVariable int id, @RequestBody Engine engine) {
        return engineService.editEngine(id, engine);
    }

    @DeleteMapping("/engine/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteEngine(@PathVariable int id) {
        return engineService.deleteEngine(id);
    }

}



