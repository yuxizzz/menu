package use_case.delete_folder;

public class DeleteFolderInputData {
    final private String foldername;
    final private String username;
    public DeleteFolderInputData(String folderName, String username) {
        this.foldername = folderName;
        this.username = username;
    }

    String getFoldername() { return foldername;}

    String getUsername() { return username;}

}
