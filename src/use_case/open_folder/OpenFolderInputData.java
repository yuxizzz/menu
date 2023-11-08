package use_case.open_folder;

public class OpenFolderInputData {

    final private String foldername;

    public OpenFolderInputData(String foldername) {
        this.foldername = foldername;
    }


    String getFoldername() {
        return foldername;
    }
}

