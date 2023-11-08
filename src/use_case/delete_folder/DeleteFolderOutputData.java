package use_case.delete_folder;

import java.util.ArrayList;

public class DeleteFolderOutputData {
    private boolean useCaseFailed;
    private String folderDeleted;

    public DeleteFolderOutputData(String folderDeleted, boolean useCaseFailed) {
        this.useCaseFailed = useCaseFailed;
        this.folderDeleted = folderDeleted;
    }

    public String getFolderDeleted() {
        return folderDeleted;
    }

}
