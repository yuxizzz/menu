package entity;

import java.util.HashMap;

public interface Folder {
    void removeRecipe(Integer recipeID);
    String getName();
    HashMap getRecipeMap();
}
