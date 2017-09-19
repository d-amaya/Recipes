package com.springboot.recipeapp.repositories;

import com.springboot.recipeapp.domain.UnitOfMeasure;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * Created by Daniel on 18/09/2017.
 */
public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {
    public Optional<UnitOfMeasure> findByUom(String uom);
}
