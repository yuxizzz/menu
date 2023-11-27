package interface_adapter.open_folder;


public class OpenFolderState {
    private String foldername = "";
    private String foldernameError = null;

    public OpenFolderState(OpenFolderState copy) {
        foldername = copy.foldername;
        foldernameError = copy.foldernameError;
    }

    // Because of the previous copy constructor, the default constructor must be explicit.
    public OpenFolderState() {}

    public String getFoldername() {
        return foldername;
    }

    public String getFoldernameError() {
        return foldernameError;
    }


    public void setFoldername(String foldername) {
        this.foldername = foldername;
    }

    public void setFoldernameError(String foldernameError) {
        this.foldernameError = foldernameError;
    }



}
