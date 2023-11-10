package entity.folder;

import entity.recipe.Recipe;

import java.util.HashMap;

public class CommonFolder implements Folder {
    private String foldername;
    private HashMap<Integer, Recipe> recipeMap;

    public CommonFolder(String foldername) {
        this.foldername = foldername;
        this.recipeMap = new HashMap<Integer, Recipe>();
    }
    @Override
    public String getName() {
        return foldername;
    }
    @Override
    public HashMap<Integer, Recipe> getRecipeMap() {
        return recipeMap;
    }
    @Override
    public void removeRecipe(Integer recipeId) {
        if (recipeMap.containsKey(recipeId)) {
            recipeMap.remove(recipeId);
        }
    }
}