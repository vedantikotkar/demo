package com.example.demo.controller;

import com.example.demo.model.Model;
import com.example.demo.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/data")
public class ModelController {

    @Autowired
    private ModelService modelService;

    @GetMapping
    public List<Model> getAllData() {
        return modelService.getAllData();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Model> getDataById(@PathVariable Long id) {
        Optional<Model> data = modelService.getDataById(id);
        return data.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Model createData(@RequestBody Model data) {
        return modelService.save(data);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Model> updateData(@PathVariable Long id, @RequestBody Model data) {
        if (!modelService.getDataById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        data.setId(id);
        return ResponseEntity.ok(modelService.save(data));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteData(@PathVariable Long id) {
        if (!modelService.getDataById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        modelService.deleteData(id);
        return ResponseEntity.noContent().build();
    }
}
