package interface_adapter.delete_folder;

import interface_adapter.logged_in.LoggedInState;

public class DeleteFolderState {
    private String folderDeleted = "";

    private String username = "";

    public DeleteFolderState(DeleteFolderState copy) {
        username = copy.username;
    }

    public DeleteFolderState(){
    }

    public void setFolderDeleted(String folderDeleted) {
        this.folderDeleted = folderDeleted;
    }
    public String getFolderDeleted(){return this.folderDeleted; }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
}
