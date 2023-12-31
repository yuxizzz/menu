package interface_adapter.open_folder;


import interface_adapter.logged_in.LoggedInState;

import java.util.ArrayList;
import java.util.HashMap;

public class OpenFolderState {
    private String foldername = "";
    private String username = "";


    private HashMap<Integer, ArrayList> recipeMap;

    public OpenFolderState(interface_adapter.open_folder.OpenFolderState copy) {
        foldername = copy.foldername;
        username = copy.username;
    }

    // Because of the previous copy constructor, the default constructor must be explicit.
    public OpenFolderState() {
    }

    public String getFoldername() {

        return foldername;
    }

    public void setFoldername(String foldername) {

        this.foldername = foldername;

    }
    public void setFoldernameError(String error) {
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setRecipeMap(HashMap<Integer, ArrayList> RecipeMap) {
        this.recipeMap = recipeMap;
    }

    public HashMap<Integer, ArrayList> getRecipeMap(){
        return recipeMap;
    }
}
