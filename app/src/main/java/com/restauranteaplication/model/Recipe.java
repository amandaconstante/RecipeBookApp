package com.restauranteaplication.model;

public class Recipe {
    private String recipeName;
    private String recipeCategory;
    private String recipeInstructions;

    public Recipe(String recipeName, String recipeCategory, String recipeInstructions) {
        this.recipeName = recipeName;
        this.recipeCategory = recipeCategory;
        this.recipeInstructions = recipeInstructions;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public String getRecipeCategory() {
        return recipeCategory;
    }

    public void setRecipeCategory(String recipeCategory) {
        this.recipeCategory = recipeCategory;
    }

    public String getRecipeInstructions() {
        return recipeInstructions;
    }

    public void setRecipeInstructions(String recipeInstructions) {
        this.recipeInstructions = recipeInstructions;
    }
}
