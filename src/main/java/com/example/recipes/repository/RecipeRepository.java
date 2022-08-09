package com.example.recipes.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import com.example.recipes.dto.RecipeDto;
import com.example.recipes.entities.RecipeEntity;

import java.util.ArrayList;
import java.util.List;

public interface RecipeRepository extends CrudRepository<RecipeEntity, Long> {
}
