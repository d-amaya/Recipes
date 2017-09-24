package com.springboot.recipeapp.controllers;

import com.springboot.recipeapp.domain.Category;
import com.springboot.recipeapp.domain.UnitOfMeasure;
import com.springboot.recipeapp.repositories.CategoryRepository;
import com.springboot.recipeapp.repositories.UnitOfMeasureRepository;
import com.springboot.recipeapp.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

/**
 * Created by Daniel on 17/09/2017.
 */
@Controller
public class IndexController {

    private RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({ "", "/", "/index" })
    public String getIndexPage(Model model) {
        model.addAttribute("recipes", recipeService.getRecipes());
        return "index";
    }
}
