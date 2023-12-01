package data_access;

import entity.folder.CommonFolder;
import entity.folder.Folder;
import entity.recipe.CommonRecipe;
import entity.recipe.Recipe;
import entity.recipe.UserRecipe;
import use_case.add_recipe_to_folder.AddRecipeToFolderDataAccessInterface;
import use_case.collect_recipe.CollectRecipeDataAccessInterface;
import use_case.delete_folder.DeleteFolderUserDataAccessInterface;

import java.util.ArrayList;
import java.util.HashMap;

public class InMemoryFolderDataAccessObject implements DeleteFolderUserDataAccessInterface, CollectRecipeDataAccessInterface,
        AddRecipeToFolderDataAccessInterface {
    //TODO mini DAO used to test the Folder usecases
    private HashMap<String, ArrayList<String>> folders = new HashMap<>();

    public InMemoryFolderDataAccessObject() {
        ArrayList<String> recipe = new ArrayList<>();
        recipe.add(1);
        folders.put("A", new ArrayList<>());
        folders.put("B", recipe);

    }


    @Override
    public String deleteFolder(String folderName) {
        // remove 1 folder
        return null;
    }


    @Override
    public ArrayList<String> getAllFolders(String username) {
        ArrayList<String> foldernames = new ArrayList<>();
        for (String f : folders.keySet()) {
            foldernames.add(f);
        }
        return foldernames;
    }

    @Override
    public String addRecipeToFolder(String folderName, Integer recipeID) {
        return null;
    }
}
