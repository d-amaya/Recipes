package com.springboot.recipeapp.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by Daniel on 17/09/2017.
 */
@Data
@Entity
public class UnitOfMeasure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String uom;
}
