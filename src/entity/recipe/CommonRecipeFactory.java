package entity.recipe;

import entity.recipe.Recipe;

import java.util.List;

public class CommonRecipeFactory implements RecipeFactory {

    @Override
    public Recipe creat(String name, String ingredients, String nutrition, String instructions, String image,
                        String recipeurl, Integer recipeid) {
        return new CommonRecipe(name, ingredients, nutrition, instructions, image,
                recipeurl, recipeid);
    }
}

