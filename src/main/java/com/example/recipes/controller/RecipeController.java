package com.example.recipes.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.recipes.dto.IdHolderDto;
import com.example.recipes.dto.RecipeDto;
import com.example.recipes.service.RecipeService;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.NO_CONTENT;

@RequiredArgsConstructor
@RestController
public class RecipeController {
    private final RecipeService recipeService;

    @GetMapping("api/recipe/{id}")
    public ResponseEntity<RecipeDto> getRecipe(@PathVariable("id") Long id) {
        RecipeDto result = recipeService.getRecipe(id);
        if (result == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(result);
    }

    @PostMapping("api/recipe/new")
    public IdHolderDto saveRecipe(@Valid @RequestBody RecipeDto recipe){
        long id = recipeService.saveRecipe(recipe);
        return new IdHolderDto(id);
    }

    @DeleteMapping("api/recipe/{id}")
    public ResponseEntity<?> deleteRecipe(@PathVariable("id") Long id) {

        if (!recipeService.delete(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(NO_CONTENT);
    }
}
