package entity;

import java.util.HashMap;

public class DefaultFolder implements Folder{
    private String folderName;
    private HashMap<Integer, Recipe> recipeMap;

    public DefaultFolder(String newFolderName) {
        this.folderName = newFolderName;
        this.recipeMap = new HashMap<Integer, Recipe>();
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
