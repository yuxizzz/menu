package interface_adapter.logged_in;


import java.util.ArrayList;

public class LoggedInState {
    private String username = "";

    private ArrayList<String> foldernames = new ArrayList<>();

    public LoggedInState(LoggedInState copy) {
        username = copy.username;
        foldernames = copy.foldernames;
    }

    // Because of the previous copy constructor, the default constructor must be explicit.
    public LoggedInState() {}

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public void setFoldernames(ArrayList<String> foldernames){
        this.foldernames = foldernames;
    }

    public ArrayList<String> getFoldernames() {
        return foldernames;
    }

    }
