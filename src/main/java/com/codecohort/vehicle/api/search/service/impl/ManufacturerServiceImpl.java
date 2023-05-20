package com.codecohort.vehicle.api.search.service.impl;

import com.codecohort.vehicle.api.search.dao.ManufacturerDAO;
import com.codecohort.vehicle.api.search.entity.Manufacturer;
import com.codecohort.vehicle.api.search.service.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {

    private ManufacturerDAO _manufacturerDAO;

    @Autowired
    public ManufacturerServiceImpl(ManufacturerDAO manufacturerDAO) {
        this._manufacturerDAO = manufacturerDAO;
    }

    @Override
    public Manufacturer saveManufacturer(Manufacturer manufacturer) {
        return _manufacturerDAO.save(manufacturer);
    }

    @Override
    public Manufacturer getManufacturerById(int id) {
        Optional<Manufacturer> manufacturer =  _manufacturerDAO.findById(id);
        if(manufacturer.isPresent()) {
            return manufacturer.get();
        }
        return null;
    }

    @Override
    public List<Manufacturer> getAllManufacturers() {
        return _manufacturerDAO.findAll();
    }
}
