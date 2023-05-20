package com.codecohort.vehicle.api.search.dao;

import com.codecohort.vehicle.api.search.entity.ManufactureYear;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManufactureYearDAO extends JpaRepository<ManufactureYear,Integer> {
}
