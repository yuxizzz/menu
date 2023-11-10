package interface_adapter.delete_folder;

import use_case.delete_folder.DeleteFolderInputBoundary;
import use_case.delete_folder.DeleteFolderInputData;


public class DeleteFolderController {
    final DeleteFolderInputBoundary deleteFolderInteractor;

    public DeleteFolderController(DeleteFolderInputBoundary deleteFolderInteractor) {
        this.deleteFolderInteractor = deleteFolderInteractor;
    }

    public void execute(String folderName) {
        DeleteFolderInputData deleteFolderInputData = new DeleteFolderInputData(folderName);
        deleteFolderInteractor.execute(deleteFolderInputData);
    }
}
