package com.springboot.recipeapp.services;

import com.springboot.recipeapp.domain.Recipe;
import com.springboot.recipeapp.repositories.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Daniel on 23/09/2017.
 */
@Slf4j
@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }


    @Override
    public Set<Recipe> getRecipes() {
        log.debug("Looking for recipes inside recipe service.");

        Set<Recipe> recipes = new HashSet<>();
        this.recipeRepository.findAll().iterator().forEachRemaining(recipes::add);
        return recipes;
    }
}
