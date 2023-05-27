package com.codecohort.vehicle.api.search.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="trim_types")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrimType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="trim_type")
    private String trimType;
}
