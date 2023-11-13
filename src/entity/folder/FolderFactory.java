package entity.folder;

import entity.recipe.Recipe;

import java.util.HashMap;

public interface FolderFactory {
    Folder create(String foldername);
    Folder create(String foldername, HashMap<Integer, Recipe> recipeHashMap);
}
