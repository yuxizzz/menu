package use_case.collect_recipe;

import java.util.ArrayList;
import java.util.HashMap;

public class CollectRecipeOutputData {
    private final ArrayList<String> folders;
    private final Integer recipeID;
    private final int userID;

    public CollectRecipeOutputData(ArrayList<String> folders, Integer recipeID, int userID) {
        this.folders = folders;
        this.recipeID = recipeID;
        this.userID = userID;
    }

    public ArrayList<String> getFolders() {
        return folders;
    }

    public Integer getRecipeID() {
        return recipeID;
    }
    public int getUserID() {
        return userID;
    }

}
