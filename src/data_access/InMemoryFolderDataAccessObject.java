package data_access;

import use_case.add_recipe_to_folder.AddRecipeToFolderDataAccessInterface;
import use_case.collect_recipe.CollectRecipeDataAccessInterface;
import use_case.delete_folder.DeleteFolderUserDataAccessInterface;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * MiniFolderDAO used for usecase test only!
 * folders contains A folder with no recipe/Integer, contains B folder with 1 recipe/Integer 1
 */

public class InMemoryFolderDataAccessObject implements DeleteFolderUserDataAccessInterface,
        CollectRecipeDataAccessInterface, AddRecipeToFolderDataAccessInterface {
    private HashMap<String, ArrayList<Integer>> folders = new HashMap<>();

    public InMemoryFolderDataAccessObject() {
        ArrayList<Integer> recipeID = new ArrayList<>();
        recipeID.add(1);
        folders.put("A", new ArrayList<>());
        folders.put("B", recipeID);
    }


    @Override
    public String deleteFolder(String folderName) {
        // remove 1 folder
        return null;
    }


    @Override
    public ArrayList<String> getAllFolders(String username) {
        ArrayList<String> foldernames = new ArrayList<>();
        foldernames.addAll(folders.keySet());
        return foldernames;
    }

    @Override
    public Boolean addRecipeToFolder(String folderName, Integer recipeID) {
        ArrayList<Integer> recipe = folders.get(folderName);
        if (recipe.contains(recipeID)) {
            return false;
        } else {
            recipe.add(recipeID);
            return true;
        }
    }
}
