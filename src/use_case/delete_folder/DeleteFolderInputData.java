package use_case.delete_folder;

public class DeleteFolderInputData {
    final private String foldername;
    public DeleteFolderInputData(String folderName) {
        this.foldername = folderName;
    }

    String getFoldername() { return foldername;}
}
