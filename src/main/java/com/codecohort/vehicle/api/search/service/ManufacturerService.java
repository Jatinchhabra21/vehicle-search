package com.codecohort.vehicle.api.search.service;

import com.codecohort.vehicle.api.search.entity.Manufacturer;

import java.util.List;

public interface ManufacturerService {

    Manufacturer saveManufacturer(Manufacturer manufacturer);

    List<Manufacturer> getAllManufacturers();

    Manufacturer getManufacturerById(int id);

    Manufacturer updateManufacturer(int id, Manufacturer updatedManufactuer);
}
