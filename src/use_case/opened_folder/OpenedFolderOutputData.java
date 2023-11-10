package use_case.opened_folder;

import use_case.login.LoginOutputData;

public class OpenedFolderOutputData {
    private final String foldername;
    private boolean useCaseFailed;

    public OpenedFolderOutputData(String foldername, boolean useCaseFailed) {
        this.foldername = foldername;
    }

    public String getFoldername() {
        return foldername;
    }
}
