package interface_adapter.add_recipe_to_folder;

import java.util.ArrayList;

public class AddRecipeToFolderState {
    private String message = "";
    private String messageError = null;
    private ArrayList<String> folderNames;
    private Integer recipeID;
    private int userID;


    public AddRecipeToFolderState() {
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setFolderNames(ArrayList<String> folders) {
        this.folderNames = folders;
    }


    public void setRecipeID(Integer recipeID) {
        this.recipeID = recipeID;
    }


    public void setUserID(int userID) {
        this.userID = userID;
    }

    public Integer getRecipeID() {
        return recipeID;
    }

    public int getUserID() {
        return userID;
    }
}