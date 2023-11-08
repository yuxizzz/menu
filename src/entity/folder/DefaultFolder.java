package entity.folder;

import entity.recipe.Recipe;
import entity.recipe.UserRecipe;

import java.util.HashMap;

public class DefaultFolder implements Folder {
    private String folderName;
    private HashMap<Integer, UserRecipe> recipeMap;

    public DefaultFolder() {
        this.folderName = "My Recipes";
        this.recipeMap = new HashMap<Integer, UserRecipe>();
    }

    @Override
    public void removeRecipe(Integer recipeID) {
        recipeMap.remove(recipeID);
    }

    @Override
    public String getName() {
        return folderName;
    }

    @Override
    public HashMap getRecipeMap() {
        return recipeMap;
    }
}
