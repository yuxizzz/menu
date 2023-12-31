package interface_adapter.add_recipe_to_folder;

import java.util.ArrayList;

public class AddRecipeToFolderState {
    private String message = "";
    private String messageError = null;
    private ArrayList<String> folderNames = new ArrayList<>();
    private Integer recipeID;
    private String username;


    public AddRecipeToFolderState() {
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setFolderNames(ArrayList<String> folders) {
        this.folderNames = folders;
    }

    public ArrayList<String> getFolderNames(){return folderNames;}


    public void setRecipeID(Integer recipeID) {
        this.recipeID = recipeID;
    }


    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getRecipeID() {
        return recipeID;
    }

    public String getUsername() {
        return username;
    }

    public void setUserID(String userID) {
    }

    public void setMessageError(String recipeAlreadyExisted) {
    }
}
