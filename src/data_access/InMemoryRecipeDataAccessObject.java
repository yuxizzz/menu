package data_access;

import entity.recipe.CommonRecipe;
import entity.recipe.CommonRecipeFactory;
import entity.recipe.Recipe;
import entity.recipe.RecipeFactory;

import java.util.HashMap;
import java.util.Map;

public class InMemoryRecipeDataAccessObject {
    private final Map<Integer, Recipe> recipeList = new HashMap<>();
    private RecipeFactory recipeFactory;
    public InMemoryRecipeDataAccessObject() {
        recipeFactory = new CommonRecipeFactory();
        Recipe recipe2 = new CommonRecipe("1", "1", "1", "1", "1", "1", 2);
        Recipe recipe1 = new CommonRecipe("1", "1", "1", "1", "1", "1", 1);
        Recipe recipe3 = new CommonRecipe("1", "1", "1", "1", "1", "1", 3);
        recipeList.put(recipe1.getRecipeID(), recipe1);
        recipeList.put(recipe2.getRecipeID(), recipe2);
        recipeList.put(recipe3.getRecipeID(), recipe3);
    }

    public Recipe getRecipeFromFile(Integer recipeID) {
        return recipeList.get(recipeID);
    }
}
