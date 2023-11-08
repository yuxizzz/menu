package interface_adapter.create_folder;

public class CreateFolderState {
    private String foldername = "";
    private String foldernameError = null;
    public CreateFolderState(CreateFolderState copy) {
        foldername = copy.foldername;
        foldernameError = copy.foldernameError;
    }
    public CreateFolderState() {
    }
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
