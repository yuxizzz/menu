package entity;

import java.util.HashMap;

public interface Folder {
    String getName();
    HashMap<Integer, Recipe> getRecipeMap();
    void removeRecipe(Integer recipeId);
}
