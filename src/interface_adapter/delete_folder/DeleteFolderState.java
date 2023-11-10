package interface_adapter.delete_folder;

public class DeleteFolderState {
    private String folderDeleted = "";

    public DeleteFolderState(){
    }

    public void setFolderDeleted(String folderDeleted) {
        this.folderDeleted = folderDeleted;
    }
    public String getFolderDeleted(){return this.folderDeleted; }
}
