package com.springboot.recipeapp.services;

import com.springboot.recipeapp.domain.Recipe;

import java.util.Set;

/**
 * Created by Daniel on 23/09/2017.
 */
public interface RecipeService {
    public Set<Recipe> getRecipes();
}
