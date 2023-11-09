package entity.folder;

import entity.recipe.Recipe;

import java.util.HashMap;

public class CommonFolder implements Folder {
    private String folderName;
    private HashMap<Integer, Recipe> recipeMap;

    @Override
    public void removeRecipe(Integer recipeID) {
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public HashMap getRecipeMap() {
        return null;
    }
}
