package use_case.create_folder;

public class CreateFolderInputData {
    final private String foldername;

    public CreateFolderInputData(String foldername) {
        this.foldername = foldername;
    }

    String getFoldername() {
        return foldername;
    }
}
