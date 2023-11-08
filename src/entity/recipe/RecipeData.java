package entity.recipe;

import entity.recipe.CommonRecipe;

import java.util.List;

public class RecipeData extends CommonRecipe {
    public RecipeData(String name, String ingredients, String nutrition, String instructions, List<String> tag) {
        super(name, ingredients, nutrition, instructions, tag);
    }
//    public RecipeData(String name, String ingredients, String nutrition, String instructions, List<String> tag, Map<String, Boolean> allergy) {
//        super(name, ingredients, nutrition, instructions, tag, allergy);
    }

