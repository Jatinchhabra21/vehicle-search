package com.codecohort.vehicle.api.search.controller;

import com.codecohort.vehicle.api.search.entity.Manufacturer;
import com.codecohort.vehicle.api.search.exception.ManufacturerNotFoundException;
import com.codecohort.vehicle.api.search.exception.MissingFieldException;
import com.codecohort.vehicle.api.search.service.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/manufacturers")
public class ManufacturerController {


    private ManufacturerService _manufacturerService;

    @Autowired
    public ManufacturerController(ManufacturerService manufacturerService) {
        this._manufacturerService = manufacturerService;
    }

    @GetMapping
    public ResponseEntity<List<Manufacturer>> getAllManufacturerInDB() {
        List<Manufacturer> dbRecords = _manufacturerService.getAllManufacturers();
        return ResponseEntity.ok(dbRecords);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Manufacturer> getManufacturerById(@PathVariable int id) throws ManufacturerNotFoundException {
        Manufacturer dbRecord = _manufacturerService.getManufacturerById(id);

        if(dbRecord == null) {
            throw new ManufacturerNotFoundException("No manufacturer found for Id - "+id);
        }

        return ResponseEntity.ok(dbRecord);
    }

    @PostMapping
    public ResponseEntity<Manufacturer> createManufacturerInDB(@RequestBody Manufacturer manufacturer) {
        Manufacturer dbRecord = _manufacturerService.saveManufacturer(manufacturer);
        return new ResponseEntity<>(dbRecord, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Manufacturer> updateManufacturerInDB(@PathVariable int id, @RequestBody Manufacturer updatedManufacturer, BindingResult result) throws Exception {

        if(result.hasErrors()) {
            List<ObjectError> errors = result.getAllErrors();
            throw new MissingFieldException(errors.get(0).getDefaultMessage());
        }

        Manufacturer dbManufacturer = _manufacturerService.updateManufacturer(id, updatedManufacturer);
        if(dbManufacturer == null) {
            throw new ManufacturerNotFoundException("No manufacturer found for Id - "+id);
        }

        return new ResponseEntity<>(dbManufacturer, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteManufacturerById(@PathVariable int id) throws ManufacturerNotFoundException {
        _manufacturerService.deleteManufacturer(id);
        return new ResponseEntity<>("Manufacturer DELETED with ID - "+ id, HttpStatus.OK);
    }
}
