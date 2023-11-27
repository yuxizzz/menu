package interface_adapter.create_folder;

import interface_adapter.logged_in.LoggedInState;

public class CreateFolderState {
    private String foldername = "";
    private String foldernameError = null;
    private String username = "";

    public CreateFolderState(CreateFolderState copy) {
        foldername = copy.foldername;
        foldernameError = copy.foldernameError;
        this.username = copy.username;
    }
    public CreateFolderState() {
    }
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
