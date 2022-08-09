package com.example.recipes.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecipeDto {

    @NotBlank
    private String name;
    @NotBlank
    private String description;
    @NotNull
    @Size(min =1 )
    private List<String> ingredients;
    @NotNull
    @Size(min =1 )
    private List<String> directions;
}
