package interface_adapter.delete_folder;

import use_case.delete_folder.DeleteFolderInputBoundary;
import use_case.delete_folder.DeleteFolderInputData;


public class DeleteFolderController {
    final DeleteFolderInputBoundary deleteFolderInteractor;

    public DeleteFolderController(DeleteFolderInputBoundary deleteFolderInteractor) {
        this.deleteFolderInteractor = deleteFolderInteractor;
    }

    public void execute(String folderName, String username) {
        DeleteFolderInputData deleteFolderInputData = new DeleteFolderInputData(folderName, username);
        deleteFolderInteractor.execute(deleteFolderInputData);
    }
}
