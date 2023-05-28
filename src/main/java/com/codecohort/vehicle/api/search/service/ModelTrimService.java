package com.codecohort.vehicle.api.search.service;

import com.codecohort.vehicle.api.search.entity.Model;
import com.codecohort.vehicle.api.search.entity.TrimType;

import java.util.List;

public interface ModelTrimService {
    public Model saveModel(Model model);

    public TrimType saveTrimType(TrimType trimType);

    public List<Model> findAllModels();
}
