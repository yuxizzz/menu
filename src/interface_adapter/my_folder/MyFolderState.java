package interface_adapter.my_folder;

import interface_adapter.logged_in.LoggedInState;

import java.util.ArrayList;
import java.util.HashMap;

public class MyFolderState {
    private String username = "";
    private ArrayList<String> foldernames = new ArrayList<>();

    public MyFolderState(MyFolderState copy) {
        username = copy.username;
        foldernames = copy.foldernames;
    }

    // Because of the previous copy constructor, the default constructor must be explicit.
    public MyFolderState() {}

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public void setFoldernames(ArrayList<String> foldernames) {
        this.foldernames = foldernames;
    }
    public ArrayList<String> getFoldernames() {
        return foldernames;
    }

    public void setFoldernameError(String error) {
    }

    public void addFoldernames(String foldername) {
        this.foldernames.add(foldername);
    }
}
