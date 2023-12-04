package use_case.login;


import java.util.ArrayList;

public class LoginOutputData {

    private final String username;
    private ArrayList<String> folders = new ArrayList<>();
    private boolean useCaseFailed;

    public LoginOutputData(String username, ArrayList<String> folders, boolean useCaseFailed) {
        this.username = username;
        this.folders = folders;
        this.useCaseFailed = useCaseFailed;
    }

    public String getUsername() {
        return username;
    }

    public ArrayList<String> getFolderList(String username){
        return folders;
    };


}
