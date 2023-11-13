package use_case.open_folder;

import entity.recipe.Recipe;
import use_case.login.LoginOutputData;

import java.util.HashMap;

public class OpenFolderOutputData {
    private final String foldername;
    private boolean useCaseFailed;
    private HashMap<Integer, Recipe> recipeMap;

    public OpenFolderOutputData(String foldername, boolean useCaseFailed,
                                HashMap<Integer, Recipe> recipeMap) {
        this.foldername = foldername;
        this.recipeMap = recipeMap;
    }

    public String getFoldername() {
        return foldername;
    }
    public HashMap<Integer, Recipe> getRecipeMap() {return recipeMap;};
}
