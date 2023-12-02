package use_case.open_folder;

public class OpenFolderInputData {

    final private String foldername;

    final private String username;

    public OpenFolderInputData(String foldername, String username) {
        this.foldername = foldername;
        this.username = username;
    }


    String getFoldername() {
        return foldername;
    }

    String getUsername(){return username;}

}

