package entity.folder;

import entity.recipe.Recipe;

import java.util.HashMap;
import java.util.Iterator;

public interface Folder extends Iterable<Recipe> {

    String getName();
    HashMap<Integer, Recipe> getRecipeMap();
    void removeRecipe(Integer recipeId);

    void addRecipe(Integer recipeID, Recipe recipe);
//    String getUsername();
}
