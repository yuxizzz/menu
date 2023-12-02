package interface_adapter.opened_folder;


import interface_adapter.logged_in.LoggedInState;

import java.util.ArrayList;
import java.util.HashMap;

public class OpenedFolderState {
    private String foldername = "";
    private String username = "";

    private HashMap<Integer, ArrayList> recipeMap;


    public OpenedFolderState(OpenedFolderState copy) {
        foldername = copy.foldername;
        username = copy.username;
    }

    // Because of the previous copy constructor, the default constructor must be explicit.
    public OpenedFolderState() {
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

    public void setRecipeMap(HashMap<Integer, ArrayList> recipeMap) {
        this.recipeMap = recipeMap;
    }

    public HashMap<Integer, ArrayList> getRecipeMap(){
        return recipeMap;
    }
}
