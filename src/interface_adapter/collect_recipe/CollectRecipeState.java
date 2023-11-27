package interface_adapter.collect_recipe;

import interface_adapter.signup.SignupState;

import java.util.ArrayList;

public class CollectRecipeState {
    private ArrayList<String> folderNames;
    private String noFolderError = null;

    private Integer recipeID;
    private String username;

    public CollectRecipeState(CollectRecipeState copy) {
        folderNames = copy.folderNames;
        noFolderError = copy.noFolderError;
    }

    // Because of the previous copy constructor, the default constructor must be explicit.
    public CollectRecipeState() {
    }

    public void setUserID(String username) {
        this.username= username;
    }

    public String getUserID() {
        return username;
    }

    public void setRecipeID(Integer recipeID) {
        this.recipeID = recipeID;
    }

    public Integer getRecipeID() {
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
