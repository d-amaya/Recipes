package com.springboot.recipeapp.repositories;

import com.springboot.recipeapp.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Daniel on 18/09/2017.
 */
public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
