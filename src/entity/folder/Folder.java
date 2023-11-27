package entity.folder;

import entity.recipe.Recipe;

import java.util.HashMap;

public interface Folder {

    String getName();
    HashMap<Integer, Recipe> getRecipeMap();
    void removeRecipe(Integer recipeId);

    void addRecipe(Integer recipeID);
}
