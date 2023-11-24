package interface_adapter.collect_recipe;

import interface_adapter.signup.SignupState;

import java.util.ArrayList;

public class CollectRecipeState {
    private ArrayList<String> folderNames;
    private String noFolderError = null;

    private String recipeID = "";
    private int userID;

    public CollectRecipeState(CollectRecipeState copy) {
        folderNames = copy.folderNames;
        noFolderError = copy.noFolderError;
    }

    // Because of the previous copy constructor, the default constructor must be explicit.
    public CollectRecipeState() {
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getUserID() {
        return userID;
    }

    public void setRecipeID(String recipeID) {
        this.recipeID = recipeID;
    }

    public String getRecipeID() {
        return recipeID;
    }

    public void setFolderNames(ArrayList<String> folderNames) {
        this.folderNames = folderNames;
    }
    public ArrayList<String> getFolderNames(){ return folderNames;
    }

    public String getNoFolderError() {return noFolderError;}

    @Override
    public String toString() {
        return "CollectRecipeState{" +
                "foldernames='" + folderNames + '\'' +
                '}';
    }

    public void setNoFolderError(String error) {
        noFolderError = error;
    }
}
