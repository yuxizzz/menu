package data_access;

import entity.folder.Folder;
import entity.recipe.*;
import entity.user.User;
import use_case.edit_recipe.EditDataAccessInterface;
import use_case.get_recipe.GetRecipeDataAccessInterface;
import use_case.open_folder.OpenFolderDataAccessInterface;
import use_case.upload_recipe.UploadDataAccessInterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class InMemoryRecipeDataAccessObject implements UploadDataAccessInterface, EditDataAccessInterface,
        GetRecipeDataAccessInterface, OpenFolderDataAccessInterface {
    private final Map<Integer, Recipe> recipeList = new HashMap<>();

    private final Map<Integer, Recipe> recipeUserList = new HashMap<>();
    private RecipeFactory recipeFactory;
    public InMemoryRecipeDataAccessObject() {
        recipeFactory = new CommonRecipeFactory();
        UserRecipe recipe4 = new UserRecipe("1","1", "1", "1", "1", "1", 4, "Jessica");
        Recipe recipe2 = new CommonRecipe("1", "1", "1", "1", "1", "1", 2);
        Recipe recipe1 = new CommonRecipe("1", "1", "1", "1", "1", "1", 1);
        Recipe recipe3 = new CommonRecipe("1", "1", "1", "1", "1", "1", 3);
        recipeList.put(recipe1.getRecipeID(), recipe1);
        recipeList.put(recipe2.getRecipeID(), recipe2);
        recipeList.put(recipe3.getRecipeID(), recipe3);
        recipeUserList.put(recipe4.getRecipeID(), recipe4);
    }

    public Recipe getRecipeFromFile(Integer recipeID) {
        return recipeList.get(recipeID);
    }

    @Override
    public void editRecipe(Integer recipeID, UserRecipe userRecipe) {
        recipeList.replace(recipeID, userRecipe);

    }

    @Override
    public UserRecipe getRecipe(Integer recipeID, String username) {
        return (UserRecipe) recipeUserList.get(recipeID);
    }

    @Override
    public boolean existsByName(Integer recipeID) {
        return false;
    }

    @Override
    public void save(Recipe recipe) {

    }

    @Override
    public boolean existsByName(String identifier) {
        return false;
    }

    @Override
    public Folder get(String foldername) {
        return null;
    }

    @Override
    public HashMap<Integer, ArrayList> getrecipeMap(String foldername) {
        return null;
    }

    @Override
    public void saveRecipe(Integer recipeID, Recipe recipe, String username) {
        recipeList.put(recipeID, recipe);
    }

    @Override
    public boolean existsByRecipeID(Integer recipeID, String username) {
        return recipeList.containsKey(recipeID);
    }
}
