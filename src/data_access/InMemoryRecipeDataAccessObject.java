package data_access;

import entity.recipe.CommonRecipe;
import entity.recipe.CommonRecipeFactory;
import entity.recipe.Recipe;
import entity.recipe.RecipeFactory;
import use_case.get_recipe.GetRecipeDataAccessInterface;

import java.util.HashMap;
import java.util.Map;

public class InMemoryRecipeDataAccessObject implements GetRecipeDataAccessInterface{
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

    @Override
    public boolean existsByName(Integer recipeID) {
        recipeList.get(recipeID);
        if (recipeList.containsKey(recipeID)) {
            return true;
        }
        return false;
    }

    @Override
    public void save(Recipe recipe) {
        this.recipeList.put(recipe.getRecipeID(), recipe);
    }
}
