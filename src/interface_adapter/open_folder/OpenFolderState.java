package interface_adapter.open_folder;


import interface_adapter.edit_recipe.EditRecipeState;

public class OpenFolderState {
    private String foldername = "";
    private String foldernameError = null;

    private String username = "";


    public OpenFolderState(OpenFolderState copy) {
        foldername = copy.foldername;
        foldernameError = copy.foldernameError;
        username = copy.username;
    }

    // Because of the previous copy constructor, the default constructor must be explicit.
    public OpenFolderState() {}

    public String getFoldername() {
        return foldername;
    }

    public String getFoldernameError() {
        return foldernameError;
    }


    public void setFoldername(String foldername) {
        this.foldername = foldername;
    }

    public void setFoldernameError(String foldernameError) {
        this.foldernameError = foldernameError;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

}
