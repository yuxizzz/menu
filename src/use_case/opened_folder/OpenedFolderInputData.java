package use_case.opened_folder;

public class OpenedFolderInputData {

    final private String foldername;

    public OpenedFolderInputData(String foldername) {
        this.foldername = foldername;
    }


    String getFoldername() {
        return foldername;
    }
}

