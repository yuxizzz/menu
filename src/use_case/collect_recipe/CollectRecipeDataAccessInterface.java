package use_case.collect_recipe;

import entity.folder.Folder;

import java.util.ArrayList;

public interface CollectRecipeDataAccessInterface {
    boolean existsAllFolders(String recipeID);

    ArrayList<Folder> getAllFolders(int userID);
}
