package com.codecohort.vehicle.api.search.dao;

import com.codecohort.vehicle.api.search.entity.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelDAO extends JpaRepository<Model, Integer> {

}
