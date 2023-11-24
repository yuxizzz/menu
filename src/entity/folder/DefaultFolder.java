package entity.folder;

import entity.recipe.Recipe;

import java.util.HashMap;

public class DefaultFolder implements Folder {
    private String folderName;
    private HashMap<Integer, Recipe> recipeMap;

    public DefaultFolder() {
        this.folderName = "My Recipes";
        this.recipeMap = new HashMap<Integer, Recipe>();
    }

    public DefaultFolder(String foldername, HashMap<Integer, Recipe> recipeMap) {
        this.folderName = foldername;
        this.recipeMap = recipeMap;
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
    public HashMap<Integer, Recipe> getRecipeMap() {
        return recipeMap;
    }
}
