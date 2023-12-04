package data_access;

import entity.folder.CommonFolder;
import entity.folder.Folder;
import entity.recipe.CommonRecipe;
import entity.recipe.Recipe;
import entity.recipe.UserRecipe;
import use_case.add_recipe_to_folder.AddRecipeToFolderDataAccessInterface;
import use_case.collect_recipe.CollectRecipeDataAccessInterface;
import use_case.delete_userRecipe.DeleteRecipeDataAccessInterface;
import use_case.open_folder.OpenFolderDataAccessInterface;
import use_case.remove_recipe.RemoveDataAccessInterface;

import java.util.*;

/**
 * MiniFolderDAO used for usecase test only!
 * folders contains A folder with no recipe/Integer, contains B folder with 1 recipe/Integer 1
 */

public class InMemoryFolderDataAccessObject implements CollectRecipeDataAccessInterface, AddRecipeToFolderDataAccessInterface,
        DeleteRecipeDataAccessInterface, OpenFolderDataAccessInterface, RemoveDataAccessInterface {

//    private final Map<String, Folder> folders = new HashMap<>();
//
//    private FolderFactory folderFactory;
//    private InMemoryRecipeDataAccessObject recipeDataAccessObject;
//    private InMemoryUserDataAccessObject userDataAccessObject;

    private HashMap<String, ArrayList<Integer>> folders = new HashMap<>();
    private HashMap<Integer, String> recipes = new HashMap<>();
    private Folder demo;

    public InMemoryFolderDataAccessObject() {
        ArrayList<Integer> recipeID = new ArrayList<>();
        recipeID.add(1);
        folders.put("A", new ArrayList<>());
        folders.put("B", recipeID);
        recipes.put(1, "recipe info");
        Folder demo = new CommonFolder("demo");
        this.demo = demo;
        Recipe recipe1 = new CommonRecipe("1", "1", "1", "1", "1", "1", 1);
        demo.addRecipe(recipe1.getRecipeID(), recipe1);
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
    public boolean existsByName(String identifier) {
        if (folders.containsKey(identifier)) {
            return true;
        } else if (Objects.equals(identifier, demo.getName())) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Folder get(String foldername) {
        return demo;
    }

    @Override
    public HashMap<Integer, ArrayList> getrecipeMap(String foldername) {
        HashMap<Integer, ArrayList> recipeMap = new HashMap<>();
        if (foldername == demo.getName()) {
            for (Recipe r: demo.getRecipeMap().values()) {
                ArrayList<String> recipes = new ArrayList<>();
                recipes.add(r.getName());
                recipeMap.put(r.getRecipeID(), recipes);
            }
            return recipeMap;
        }
        return null;
    }

    @Override
    public CommonRecipe removeRecipe(Integer removedRecipeID, String username, String foldername) {
        CommonRecipe r = null;
        for (Recipe recipe: demo) {
            r = (CommonRecipe) recipe;

        }
        return r;
    }

    @Override
    public boolean existsByRecipeID(Integer recipeID, String username) {
        if (folders.containsValue(recipeID)) {
            return true;
        } else if (recipeID == 1) {
            return true;
        }
        return false;
    }
}
