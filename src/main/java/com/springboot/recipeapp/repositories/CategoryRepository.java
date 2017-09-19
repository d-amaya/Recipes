package com.springboot.recipeapp.repositories;

import com.springboot.recipeapp.domain.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * Created by Daniel on 18/09/2017.
 */
public interface CategoryRepository extends CrudRepository<Category, Long> {
    public Optional<Category> findByDescription(String description);
}
