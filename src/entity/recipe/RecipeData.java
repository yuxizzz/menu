package entity.recipe;

import entity.recipe.CommonRecipe;

import java.util.List;

public class RecipeData extends CommonRecipe {
    public RecipeData(String name, String ingredients, String nutrition, String instructions, String image, String recipeurl, Integer recipeid) {
        super(name, ingredients, nutrition, instructions, image, recipeurl, recipeid);
    }
}

