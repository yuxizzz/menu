package use_case.my_folder;

import entity.recipe.Recipe;
import use_case.login.LoginOutputData;

import java.util.ArrayList;
import java.util.HashMap;

public class MyFolderOutputData {
    private final ArrayList<String> foldernames;
    private boolean useCaseFailed;

    public MyFolderOutputData(ArrayList<String> foldernames, boolean useCaseFailed) {
        this.foldernames = foldernames;
        this.useCaseFailed = useCaseFailed;
    }

    public ArrayList<String> getFoldernames() {
        return foldernames;
    }
}
