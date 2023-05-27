package com.codecohort.vehicle.api.search.service;

import com.codecohort.vehicle.api.search.entity.Model;
import com.codecohort.vehicle.api.search.entity.TrimType;

public interface ModelTrimService {
    public Model saveModel(Model model);

    public TrimType saveTrimType(TrimType trimType);
}
