package com.springboot.recipeapp.controllers;

import com.springboot.recipeapp.domain.Recipe;
import com.springboot.recipeapp.services.RecipeService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anySet;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by Daniel on 24/09/2017.
 */
public class IndexControllerTest {

    @Mock
    RecipeService recipeService;

    @Mock
    Model model;

    IndexController indexController;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        this.indexController = new IndexController(recipeService);
    }

    @Test
    public void getIndexPage() throws Exception {
        //Given
        Set<Recipe> recipes = new HashSet<Recipe>();
        Recipe recipe = new Recipe();
        recipe.setId(1L);
        recipes.add(recipe);

        recipe = new Recipe();
        recipe.setId(2L);
        recipes.add(recipe);

        when(recipeService.getRecipes()).thenReturn(recipes);
        ArgumentCaptor<Set<Recipe>> argumentCaptor =  ArgumentCaptor.forClass(Set.class);

        //When
        String viewName = this.indexController.getIndexPage(this.model);

        //Then
        assertEquals("index", viewName);
        verify(recipeService, times(1)).getRecipes();
        verify(model, times(1)).addAttribute(eq("recipes"), argumentCaptor.capture());
        Set<Recipe> recipesModel = argumentCaptor.getValue();
        assertEquals(2, recipesModel.size());
    }

}