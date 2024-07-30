package com.example.demo.service;

import com.example.demo.model.Model;
import com.example.demo.repository.ModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModelService {

    @Autowired
    private ModelRepository modelRepository;

    public List<Model> getAllData() {
        return modelRepository.findAll();
    }

    public Optional<Model> getDataById(Long id) {
        return modelRepository.findById(id);
    }

    public Model save(Model data) {
        return modelRepository.save(data);
    }

    public void deleteData(Long id) {
        modelRepository.deleteById(id);
    }
}
