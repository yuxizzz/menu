package use_case.my_folder;

import entity.recipe.Recipe;
import use_case.login.LoginOutputData;

import java.util.HashMap;

public class MyFolderOutputData {
    private final String foldername;
    private boolean useCaseFailed;
    private HashMap<Integer, Recipe> recipeMap;

    public MyFolderOutputData(String foldername, boolean useCaseFailed,
                                HashMap<Integer, Recipe> recipeMap) {
        this.foldername = foldername;
        this.recipeMap = recipeMap;
        this.useCaseFailed = useCaseFailed;
    }

    public String getFoldername() {
        return foldername;
    }
    public HashMap<Integer, Recipe> getRecipeMap() {return recipeMap;};
}
