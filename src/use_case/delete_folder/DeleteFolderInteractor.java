package use_case.delete_folder;

//TODO delete folder from user userDAO

public class DeleteFolderInteractor implements DeleteFolderInputBoundary {
    final DeleteFolderUserDataAccessInterface deleteFolderUserDataAccessObject;
    final DeleteFolderOutputBoundary deleteFolderPresenter;

    public DeleteFolderInteractor(DeleteFolderUserDataAccessInterface deleteFolderUserDataAccessObject, DeleteFolderOutputBoundary deleteFolderOutputBoundary) {
        this.deleteFolderUserDataAccessObject = deleteFolderUserDataAccessObject;
        this.deleteFolderPresenter = deleteFolderOutputBoundary;
    }

    @Override
    public void execute(DeleteFolderInputData deleteFolderInputData) {
        String deletedFolder = deleteFolderUserDataAccessObject.deleteFolder(deleteFolderInputData.getFoldername(),
                deleteFolderInputData.getUsername());
        DeleteFolderOutputData deleteFolderOutputData = new DeleteFolderOutputData(deletedFolder + " is removed", false);
        deleteFolderPresenter.prepareSuccessView(deleteFolderOutputData);
    }
}
