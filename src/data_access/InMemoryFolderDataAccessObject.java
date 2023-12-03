package data_access;

import entity.folder.CommonFolderFactory;
import entity.folder.Folder;
import entity.folder.FolderFactory;
import entity.recipe.CommonRecipeFactory;
import entity.recipe.Recipe;
import entity.recipe.RecipeFactory;
import entity.recipe.UserRecipe;
import use_case.add_recipe_to_folder.AddRecipeToFolderDataAccessInterface;
import use_case.collect_recipe.CollectRecipeDataAccessInterface;
import use_case.delete_folder.DeleteFolderUserDataAccessInterface;
import use_case.delete_userRecipe.DeleteRecipeDataAccessInterface;
import use_case.get_recipe.GetRecipeDataAccessInterface;

import java.io.IOException;
import java.util.*;

/**
 * MiniFolderDAO used for usecase test only!
 * folders contains A folder with no recipe/Integer, contains B folder with 1 recipe/Integer 1
 */

public class InMemoryFolderDataAccessObject implements CollectRecipeDataAccessInterface, AddRecipeToFolderDataAccessInterface,
        DeleteRecipeDataAccessInterface, GetRecipeDataAccessInterface {

//    private final Map<String, Folder> folders = new HashMap<>();
//
//    private FolderFactory folderFactory;
//    private InMemoryRecipeDataAccessObject recipeDataAccessObject;
//    private InMemoryUserDataAccessObject userDataAccessObject;

    private HashMap<String, ArrayList<Integer>> folders = new HashMap<>();

    public InMemoryFolderDataAccessObject() {
        ArrayList<Integer> recipeID = new ArrayList<>();
        recipeID.add(1);
        folders.put("A", new ArrayList<>());
        folders.put("B", recipeID);
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

//    public InMemoryFolderDataAccessObject() {
//        FolderFactory folderFactory = new CommonFolderFactory();
//
//        Folder folder1 = folderFactory.create("folder1");
//        Folder folder2 = folderFactory.create("folder2");
//        folders.put(folder1.getName(), folder1);
//        folders.put(folder2.getName(), folder2);
//
//        recipeDataAccessObject = new InMemoryRecipeDataAccessObject();
//        RecipeFactory recipeFactory = new CommonRecipeFactory();
//        Recipe recipe1 = recipeFactory.create("1", "1", "1", "1", "1", "1", 1);
//        folder1.addRecipe(1, recipe1);
//        Recipe recipeUser = new UserRecipe("1", "1", "1", "1", "1", "1", 12, "user1");
//        userDataAccessObject = new InMemoryUserDataAccessObject();
//    }

    @Override
    public UserRecipe deleteRecipe(Integer recipeid, String username) {
        return null;
    }

    @Override
    public HashMap<Integer, ArrayList> getrecipeMap(String foldername) {
        return null;
    }

    @Override
    public boolean existsByRecipeID(Integer recipeID, String username) {
        return false;
    }

    @Override
    public boolean existsByName(Integer recipeID) {
        return false;
    }

    @Override
    public void save(Recipe recipe) {

    }
}
