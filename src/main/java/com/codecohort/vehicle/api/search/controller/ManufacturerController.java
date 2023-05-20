package com.codecohort.vehicle.api.search.controller;

import com.codecohort.vehicle.api.search.entity.Manufacturer;
import com.codecohort.vehicle.api.search.service.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Manufacturer> getManufacturerById(@PathVariable int id) {
        Manufacturer dbRecord = _manufacturerService.getManufacturerById(id);
        return ResponseEntity.ok(dbRecord);
    }

    @PostMapping
    public ResponseEntity<Manufacturer> createManufacturerInDB(@RequestBody Manufacturer manufacturer) {
        Manufacturer dbRecord = _manufacturerService.saveManufacturer(manufacturer);
        return new ResponseEntity<>(dbRecord, HttpStatus.CREATED);
    }
}
