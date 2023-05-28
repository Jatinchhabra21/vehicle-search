package com.codecohort.vehicle.api.search.controller;

import com.codecohort.vehicle.api.search.entity.Model;
import com.codecohort.vehicle.api.search.entity.TrimType;
import com.codecohort.vehicle.api.search.service.ModelTrimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class ModelTrimController {

    private ModelTrimService _modelTrimService;

    @Autowired
    public ModelTrimController(ModelTrimService modelTrimService) {
        this._modelTrimService = modelTrimService;
    }

    @PostMapping("models")
    public ResponseEntity<Model> createModelTrim(@RequestBody Model model) {
        Model savedModel = _modelTrimService.saveModel(model);
        return new ResponseEntity<>(savedModel, HttpStatus.CREATED);
    }

    @PostMapping("trim-types")
    public ResponseEntity<TrimType> createTrimType(@RequestBody TrimType trimType) {
        TrimType savedTrimType = _modelTrimService.saveTrimType(trimType);
        return new ResponseEntity<>(savedTrimType, HttpStatus.CREATED);
    }

    @GetMapping("models")
    public ResponseEntity<List<Model>> getAllModels() {
        List<Model> models = _modelTrimService.findAllModels();
        if (models.size() > 0)
            return ResponseEntity.ok(models);
        else
            return null;
    }


}
