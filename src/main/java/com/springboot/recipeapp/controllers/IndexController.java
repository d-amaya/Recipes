package com.springboot.recipeapp.controllers;

import com.springboot.recipeapp.domain.Category;
import com.springboot.recipeapp.domain.UnitOfMeasure;
import com.springboot.recipeapp.repositories.CategoryRepository;
import com.springboot.recipeapp.repositories.UnitOfMeasureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

/**
 * Created by Daniel on 17/09/2017.
 */
@Controller
public class IndexController {

    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;

    @Autowired
    public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @RequestMapping({ "", "/", "/index" })
    public String getIndexPage() {
        Optional<Category> categoryOptional = this.categoryRepository.findByDescription("American");
        Optional<UnitOfMeasure> unitOfMeasureOptional = this.unitOfMeasureRepository.findByUom("Teaspoon");

        System.out.println("Category Id is: " + categoryOptional.get().getId());
        System.out.println("UnitOfMeasure Id is: " + unitOfMeasureOptional.get().getId());

        return "index";
    }
}
