package entity.folder;

import entity.recipe.Recipe;

import java.util.HashMap;

public class CommonFolder implements Folder {
    private String foldername;
    private HashMap<Integer, Recipe> recipeMap;
//    private String username;

    public CommonFolder(String foldername) {
        this.foldername = foldername;
        this.recipeMap = new HashMap<Integer, Recipe>();
//        this.username = username;
    }

    public CommonFolder(String foldername, HashMap recipeMap) {
        this.foldername = foldername;
        this.recipeMap = recipeMap;
//        this.username = username;
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

    @Override
    public void addRecipe(Integer recipeID, Recipe recipe) {
        recipeMap.put(recipeID, recipe);
    }
}
