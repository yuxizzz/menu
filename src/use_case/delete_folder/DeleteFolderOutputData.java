package use_case.delete_folder;

import java.util.ArrayList;

public class DeleteFolderOutputData {
    private boolean useCaseFailed;
    private String folderDeleted;

    public DeleteFolderOutputData(ArrayList<String> folderDeleted, boolean useCaseFailed) {
        this.useCaseFailed = useCaseFailed;
        this.folderDeleted = "";
        for (String r: folderDeleted) {
            this.folderDeleted += r + "\n";
        }

    }

    public String getFolderDeleted() {
        return folderDeleted;
    }

}
