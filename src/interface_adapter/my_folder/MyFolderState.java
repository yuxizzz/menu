package interface_adapter.my_folder;

import interface_adapter.logged_in.LoggedInState;

public class MyFolderState {
    private String username = "";

    public MyFolderState(MyFolderState copy) {
        username = copy.username;
    }

    // Because of the previous copy constructor, the default constructor must be explicit.
    public MyFolderState() {}

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
}
