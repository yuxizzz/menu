package entity.folder;

import entity.recipe.Recipe;

import java.util.HashMap;

public class CommonFolderFactory implements FolderFactory {

    @Override
    public Folder create(String foldername) {
        return new CommonFolder(foldername);
    }

    @Override
    public Folder create(String foldername, HashMap<Integer, Recipe> recipeHashMap) {
        return new CommonFolder(foldername, recipeHashMap);
    }
}
