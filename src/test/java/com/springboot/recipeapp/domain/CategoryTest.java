package com.springboot.recipeapp.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Daniel on 24/09/2017.
 */
public class CategoryTest {

    Category category;

    @Before
    public void setup() {
        this.category = new Category();
    }

    @Test
    public void getId() throws Exception {
        Long id = 4L;
        this.category.setId(id);
        assertEquals(id, this.category.getId());
    }

}