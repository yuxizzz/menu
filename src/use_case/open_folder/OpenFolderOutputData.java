package use_case.open_folder;

import use_case.login.LoginOutputData;

public class OpenFolderOutputData {
    private final String foldername;
    private boolean useCaseFailed;

    public OpenFolderOutputData(String foldername, boolean useCaseFailed) {
        this.foldername = foldername;
    }

    public String getFoldername() {
        return foldername;
    }
}
