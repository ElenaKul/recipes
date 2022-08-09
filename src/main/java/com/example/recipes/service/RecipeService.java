package com.example.recipes.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import com.example.recipes.dto.RecipeDto;
import com.example.recipes.entities.RecipeEntity;
import com.example.recipes.repository.RecipeRepository;

@RequiredArgsConstructor
@Component
public class RecipeService {
    private final RecipeRepository recipeRepository;

    public RecipeDto getRecipe(long id) {
        return recipeRepository.findById(id)
                .map(e -> {
                    RecipeDto dto = new RecipeDto();
                    dto.setName(e.getName());
                    dto.setDescription(e.getDescription());
                    dto.setIngredients(e.getIngredients());
                    dto.setDirections(e.getDirections());
                    return dto;
                }).orElse(null);
    }

    public long saveRecipe(RecipeDto recipe) {
        RecipeEntity entity = new RecipeEntity();
        entity.setName(recipe.getName());
        entity.setDescription(recipe.getDescription());
        entity.setDirections(recipe.getDirections());
        entity.setIngredients(recipe.getIngredients());
        return recipeRepository.save(entity)
                .getId();
    }

    public boolean delete(long id) {
        if (recipeRepository.existsById(id)) {
            recipeRepository.deleteById(id);
            return true;
        } else {
            return false;
        }

    }
}
