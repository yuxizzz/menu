package interface_adapter.opened_folder;


public class OpenedFolderState {
    private String foldername = "";

    public OpenedFolderState(OpenedFolderState copy) {
        foldername = copy.foldername;
    }

    // Because of the previous copy constructor, the default constructor must be explicit.
    public OpenedFolderState() {
    }

    public String getFoldername() {
        return foldername;
    }

    public void setFoldername(String username) {
        this.foldername = foldername;
    }
}
