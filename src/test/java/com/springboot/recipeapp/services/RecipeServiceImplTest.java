package com.springboot.recipeapp.services;

import com.springboot.recipeapp.domain.Recipe;
import com.springboot.recipeapp.repositories.RecipeRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;
import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by Daniel on 24/09/2017.
 */
public class RecipeServiceImplTest {

    RecipeService recipeService;

    @Mock
    RecipeRepository recipeRepositoryMock;


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        when(recipeRepositoryMock.findAll()).thenReturn(getRecipesMock());
        this.recipeService = new RecipeServiceImpl(this.recipeRepositoryMock);
    }

    @Test
    public void getRecipes() throws Exception {
        Set<Recipe> recipes = recipeService.getRecipes();
        assertEquals(1, recipes.size());
        verify(recipeRepositoryMock, times(1)).findAll();
    }

    private Set<Recipe> getRecipesMock() {
        Recipe recipe = new Recipe();
        Set<Recipe> recipes = new HashSet<>();
        recipes.add(recipe);
        return recipes;
    }

}