package use_case.create_folder;

public class CreateFolderInputData {
    final private String foldername;
    final private String username;

    public CreateFolderInputData(String foldername, String username) {
        this.foldername = foldername;
        this.username = username;
    }

    String getFoldername() {
        return foldername;
    }
    String getUsername() {
        return username;
    }
}
