package com.codecohort.vehicle.api.search.service.impl;

import com.codecohort.vehicle.api.search.dao.ManufacturerDAO;
import com.codecohort.vehicle.api.search.entity.Manufacturer;
import com.codecohort.vehicle.api.search.service.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {

    @Autowired
    private ManufacturerDAO manufacturerDAO;

    @Override
    public Manufacturer saveManufacturer(Manufacturer manufacturer) {
        return manufacturerDAO.save(manufacturer);
    }
}
