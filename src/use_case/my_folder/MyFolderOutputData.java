package use_case.my_folder;

import java.util.ArrayList;

public class MyFolderOutputData {
    private final ArrayList<String> foldernames;
    private boolean useCaseFailed;
    private final String username;

    public MyFolderOutputData(ArrayList<String> foldernames, String username, boolean useCaseFailed) {
        this.foldernames = foldernames;
        this.username = username;
        this.useCaseFailed = useCaseFailed;
    }

    public ArrayList<String> getFoldernames() {
        return foldernames;
    }

    public String getUserName() {return username; }
}
