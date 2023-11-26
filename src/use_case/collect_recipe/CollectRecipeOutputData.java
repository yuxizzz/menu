package use_case.collect_recipe;

import java.util.ArrayList;
import java.util.HashMap;

public class CollectRecipeOutputData {
    private final ArrayList<String> folders;
    private final Integer recipeID;
    private final String username;

    public CollectRecipeOutputData(ArrayList<String> folders, Integer recipeID, String username) {
        this.folders = folders;
        this.recipeID = recipeID;
        this.username = username;
    }

    public ArrayList<String> getFolders() {
        return folders;
    }

    public Integer getRecipeID() {
        return recipeID;
    }
    public String getUserID() {
        return username;
    }

}
