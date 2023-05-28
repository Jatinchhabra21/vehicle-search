package com.codecohort.vehicle.api.search.service.impl;

import com.codecohort.vehicle.api.search.dao.ModelDAO;
import com.codecohort.vehicle.api.search.dao.TrimTypeDAO;
import com.codecohort.vehicle.api.search.entity.Model;
import com.codecohort.vehicle.api.search.entity.TrimType;
import com.codecohort.vehicle.api.search.service.ModelTrimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.AbstractAuditable_;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModelTrimServiceImpl implements ModelTrimService {

    private final ModelDAO _modelDAO;
    private final TrimTypeDAO _trimTypeDAO;

    @Autowired
    public ModelTrimServiceImpl(ModelDAO modelDAO, TrimTypeDAO trimTypeDAO) {
        this._modelDAO = modelDAO;
        this._trimTypeDAO = trimTypeDAO;
    }

    @Override
    public Model saveModel(Model model) {
        Model savedModel = _modelDAO.save(model);
        return savedModel;
    }

    @Override
    public TrimType saveTrimType(TrimType trimType) {
        TrimType savedTrimType = _trimTypeDAO.save(trimType);
        return savedTrimType;
    }

    @Override
    public List<Model> findAllModels() {
        List<Model> models = _modelDAO.findAll();
        return models;
    }
}
